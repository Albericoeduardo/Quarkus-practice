package org.dfd.proxy;

import java.util.List;

import org.dfd.model.Episode;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/shows")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface EpisodeProxy {

    @GET
    @Path("/{id}/episodes")
    List<Episode> get(@PathParam("id") Long id);

}
