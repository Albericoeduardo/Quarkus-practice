package org.acme.service.impl;

import org.acme.entity.Projects;
import org.acme.service.ProjectsService;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/projects")
public class ProjectsServiceImpl implements ProjectsService{

    public List<Projects> projects= new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public Response getProject() {
        return Response.ok(projects).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Override
    public Response createProject(Projects newProject) {
        projects.add(newProject);
        return Response.status(Response.Status.CREATED).entity(newProject).build();
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("{id}")
    @Override
    public Response deleteProject(Long id) {
        Optional<Projects> projectToDelete = projects.stream().filter(projects -> projects.getId().equals(id)).findFirst();

        boolean removed = false;
        if (projectToDelete.isPresent()) {
            removed = projects.remove(projectToDelete.get());
        }
        if (removed) {
            Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
}
