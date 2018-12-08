package net.playground.reactive.demo.mongo.client.rest;

import net.playground.reactive.demo.commons.model.Tweet;

public class RequestValidator {

    public static void validate(String request) {
        if (request == null || request.trim().length() == 0) {
            throw new IllegalArgumentException("request may not be empty");
        }
    }

    public static void validate(Tweet request) {
        if (request == null)
            throw new IllegalArgumentException("request may not be empty");

        if (request.getText() == null || request.getText().trim().length() == 0)
            throw new IllegalArgumentException("field 'text' may not be empty");
    }
}
