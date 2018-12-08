package net.playground.reactive.demo.reactive.mongo.client.storage;

import net.playground.reactive.demo.commons.model.Tweet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface TweetRepository extends ReactiveMongoRepository<Tweet, String> {

    @Tailable
    Flux<Tweet> findWithTailableCursorBy();
}
