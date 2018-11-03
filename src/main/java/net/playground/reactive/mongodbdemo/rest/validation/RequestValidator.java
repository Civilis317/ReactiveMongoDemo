package net.playground.reactive.mongodbdemo.rest.validation;

import net.playground.reactive.mongodbdemo.model.Customer;

public class RequestValidator {

    public static void validate(String request) {
        if (request == null || request.trim().length() == 0) {
            throw new IllegalArgumentException("request may not be empty");
        }
    }

    public static void validate(Customer request) {
        if (request == null)
            throw new IllegalArgumentException("request may not be empty");

        if (request.getLastName() == null || request.getLastName().trim().length() == 0)
            throw new IllegalArgumentException("field last-name may not be empty");

        if (request.getFirstName() == null || request.getFirstName().trim().length() == 0)
            throw new IllegalArgumentException("field first-name may not be empty");
    }
}
