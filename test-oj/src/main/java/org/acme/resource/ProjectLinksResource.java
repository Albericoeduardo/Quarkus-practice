package org.acme.resource;

import org.acme.entity.ProjectLink;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

public class ProjectLinksResource {
    
    ProjectLinksResource projectLinksResource;

    @GET
    public Response getProjectLink(){
        return projectLinksResource.getProjectLink();
    }

    @POST
    public Response createProjectLink(ProjectLink newProjectLink){
        return projectLinksResource.createProjectLink(newProjectLink);
    }

    @DELETE
    public Response deleteProjectLink(@PathParam("id") Long id){
        return projectLinksResource.deleteProjectLink(id);
    }
}
