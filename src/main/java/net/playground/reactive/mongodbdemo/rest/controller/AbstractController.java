package net.playground.reactive.mongodbdemo.rest.controller;

import net.playground.reactive.mongodbdemo.rest.exceptions.CustomerExistsException;
import net.playground.reactive.mongodbdemo.rest.exceptions.CustomerNotFoundException;
import net.playground.reactive.mongodbdemo.rest.exceptions.StorageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AbstractController {

    @ExceptionHandler
    protected void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        String msg = e.getMessage() == null ? "The request was not valid" : e.getMessage();
        response.sendError(HttpStatus.BAD_REQUEST.value(), msg);
    }

    @ExceptionHandler
    protected void handleEntityNotFoundException(CustomerNotFoundException e, HttpServletResponse response) throws IOException {
        String msg = e.getMessage() == null ? "The trademark requested could not be found" : e.getMessage();
        response.sendError(HttpStatus.NOT_FOUND.value(), msg);
    }

    @ExceptionHandler
    protected void handleEntityExistsException(CustomerExistsException e, HttpServletResponse response) throws IOException {
        String msg = e.getMessage() == null ? "The trademark requested cannot be renewed" : e.getMessage();
        response.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg);
    }

    @ExceptionHandler
    protected void handleStorageException(StorageException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error caused the request to not be processed");
    }
}
