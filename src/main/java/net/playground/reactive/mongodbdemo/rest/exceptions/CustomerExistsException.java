package net.playground.reactive.mongodbdemo.rest.exceptions;

public class CustomerExistsException extends RuntimeException {

    public CustomerExistsException() {
        super();
    }

    public CustomerExistsException(String message) {
        super(message);
    }

    public CustomerExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
