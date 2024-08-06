package org.acme.resource;

import org.acme.entity.ProjectLink;
import org.acme.service.ProjectLinkService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/links")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class ProjectLinksResource {
    
    @Inject
    ProjectLinkService projectLinkService;

    @GET
    public Response getProjectLink(){
        return projectLinkService.getProjectLink();
    }

    @POST
    public Response createProjectLink(ProjectLink newProjectLink){
        return projectLinkService.createProjectLink(newProjectLink);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProjectLink(@PathParam("id") Long id){
        return projectLinkService.deleteProjectLink(id);
    }
}
