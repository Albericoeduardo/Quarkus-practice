package org.acme.resource;

import org.acme.entity.Project;
import org.acme.service.ProjectService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/projects")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class ProjectResource {

    ProjectService projectsService;
    
    @GET
    public Response getProject(){
        return projectsService.getProject();
    }

    @POST
    public Response createProject(Project newProject){
        return projectsService.createProject(newProject);
    }

    @DELETE
    public Response deleteProject(@PathParam("id") Long id){
        return projectsService.deleteProject(id);
    }
}
