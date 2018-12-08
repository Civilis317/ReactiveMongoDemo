package net.playground.reactive.demo.mongo.client.rest.controller;

import net.playground.reactive.demo.commons.exception.DocumentExistsException;
import net.playground.reactive.demo.commons.exception.DocumentNotFoundException;
import net.playground.reactive.demo.commons.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController {

    @ExceptionHandler
    protected void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        String msg = e.getMessage() == null ? "The request was not valid" : e.getMessage();
        response.sendError(HttpStatus.BAD_REQUEST.value(), msg);
    }

    @ExceptionHandler
    protected void handleNotFoundException(DocumentNotFoundException e, HttpServletResponse response) throws IOException {
        String msg = e.getMessage() == null ? "The document could not be found" : e.getMessage();
        response.sendError(HttpStatus.NOT_FOUND.value(), msg);
    }

    @ExceptionHandler
    protected void handleAlreadyExistsException(DocumentExistsException e, HttpServletResponse response) throws IOException {
        String msg = e.getMessage() == null ? "The document already exists" : e.getMessage();
        response.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg);
    }

    @ExceptionHandler
    protected void handleApplicationException(ApplicationException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error caused the request to not be processed");
    }
}
