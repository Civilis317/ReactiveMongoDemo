package net.playground.reactive.demo.mongo.client.storage;

import net.playground.reactive.demo.commons.model.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TweetRepository extends MongoRepository<Tweet, String> {
}
