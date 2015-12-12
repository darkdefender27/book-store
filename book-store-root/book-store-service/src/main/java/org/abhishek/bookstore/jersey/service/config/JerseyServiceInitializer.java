package org.abhishek.bookstore.jersey.service.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


/**
 * Created by abhishek on 14/07/15.
 */
public class JerseyServiceInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.scan("org.abhishek.bookstore.jersey.service");

        servletContext.addListener(new ContextLoaderListener(root));
    }

}
