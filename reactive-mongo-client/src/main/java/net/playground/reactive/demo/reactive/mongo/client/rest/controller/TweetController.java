package net.playground.reactive.demo.reactive.mongo.client.rest.controller;

import net.playground.reactive.demo.commons.model.Tweet;
import net.playground.reactive.demo.reactive.mongo.client.storage.TweetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/reactive-api")
public class TweetController {
    private static final Logger logger = LoggerFactory.getLogger(TweetController.class);

    private final TweetRepository repository;

    public TweetController(TweetRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/stream/tweets", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tweet> streamAllTweets() {
        return repository.findWithTailableCursorBy();
    }
}
