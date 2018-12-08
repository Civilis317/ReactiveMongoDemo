package net.playground.reactive.demo.commons.exception;

public class DocumentExistsException extends RuntimeException {

    public DocumentExistsException() {
        super();
    }

    public DocumentExistsException(String message) {
        super(message);
    }

    public DocumentExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
