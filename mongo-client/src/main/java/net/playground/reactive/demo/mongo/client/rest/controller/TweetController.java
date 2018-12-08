package net.playground.reactive.demo.mongo.client.rest.controller;

import net.playground.reactive.demo.commons.exception.DocumentNotFoundException;
import net.playground.reactive.demo.commons.model.Tweet;
import net.playground.reactive.demo.mongo.client.rest.RestResponse;
import net.playground.reactive.demo.mongo.client.rest.RequestValidator;
import net.playground.reactive.demo.mongo.client.storage.TweetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tweet")
public class TweetController extends AbstractController {
    private static final Logger logger = LoggerFactory.getLogger(TweetController.class);

    private final TweetRepository repository;
    private final MongoOperations mongoOperations;

    public TweetController(TweetRepository repository, MongoOperations mongoOperations) {
        this.repository = repository;
        this.mongoOperations = mongoOperations;
}

    @GetMapping(value = "/create")
    public boolean reCreateCollection() {
        if(mongoOperations.collectionExists("tweets")) {
            mongoOperations.dropCollection("tweets");
        }
        mongoOperations.createCollection("tweets", CollectionOptions.empty().capped().size(9999999L).maxDocuments(100L));
        return true;
    }

    @GetMapping(value = "/get")
    public @ResponseBody
    RestResponse getAllTweets() {
        RestResponse response = new RestResponse();
        repository.findAll().forEach(response::add);
        return response;
    }

    @GetMapping(value = "/get/{id}")
    public @ResponseBody
    RestResponse getAllTweets(@PathVariable(value = "id") String id) {
        RestResponse response = new RestResponse();
        Tweet tweet = repository.findById(id).orElseThrow(() -> new DocumentNotFoundException("Tweet not found for id: {" + id + "}"));
        response.add(tweet);
        return response;
    }

    @PostMapping(value = "/save")
    public @ResponseBody
    RestResponse saveTweet(@RequestBody Tweet tweet) {
        RequestValidator.validate(tweet);
        RestResponse response = new RestResponse();
        response.add(repository.save(tweet));
        return response;
    }
}
