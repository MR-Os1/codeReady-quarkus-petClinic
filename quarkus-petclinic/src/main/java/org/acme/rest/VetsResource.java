package org.acme.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import java.util.List;
import org.acme.model.Vet;

import org.acme.client.VetsRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("vets")
public class VetsResource {

    @Inject
    Template vets;

    @Inject
    @RestClient
    VetsRestClient vetsRestClient;
    

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        List<Vet> data = vetsRestClient.getAll();
        return vets.data("active", "vets")
                .data("vets", data);
    }
}