package org.acme.service.impl;

import org.acme.entity.Project;
import org.acme.service.ProjectService;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import jakarta.ws.rs.core.Response;

public class ProjectServiceImpl implements ProjectService{

    public List<Project> projects= new ArrayList<>();

    @Override
    public Response getProject() {
        return Response.ok(projects).build();
    }

    @Override
    public Response createProject(Project newProject) {
        projects.add(newProject);
        return Response.status(Response.Status.CREATED).entity(newProject).build();
    }

    @Override
    public Response deleteProject(Long id) {
        Optional<Project> projectToDelete = projects.stream().filter(projects -> projects.getId().equals(id)).findFirst();

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
