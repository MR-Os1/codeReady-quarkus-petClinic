package org.acme.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/")
public class WelcomeResource {

    @Inject
    Template welcome;

    @ConfigProperty(name = "message.hello.quarkus")
    String message;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return welcome.data("active", "home")
                .data("message", message);
    }

}