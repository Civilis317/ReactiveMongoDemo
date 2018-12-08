package net.playground.reactive.demo.mongo.client.rest;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.playground.reactive.demo.commons.model.Tweet;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
public class RestResponse {
    private List<Tweet> data = new ArrayList<>(1024);

    // convenience method
    public void add(Tweet tweet) {
        this.data.add(tweet);
    }

    public int getCount() {
        if (data == null) return 0;
        return data.size();
    }
}
