package org.abhishek.bookstore.jersey.service;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by abhishek on 06/07/15.
 */
@ApplicationPath("api/v1")
public class JerseyService extends ResourceConfig{

    public JerseyService(){

    }

}
