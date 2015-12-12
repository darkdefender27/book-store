package org.abhishek.bookstore.jersey.service.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by abhishek on 22/07/15.
 */
public class CustomException extends WebApplicationException{

    public CustomException(String message) {
        super(Response.status(Response.Status.BAD_REQUEST).entity(message).build());
    }

}
