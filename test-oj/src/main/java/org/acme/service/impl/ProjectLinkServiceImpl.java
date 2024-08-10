package org.acme.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.dto.ProjectLinkDTO;
import org.acme.model.Project;
import org.acme.model.ProjectLink;
import org.acme.service.ProjectLinkService;
import org.acme.service.ProjectService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ProjectLinkServiceImpl implements ProjectLinkService {

    public List<ProjectLink> projectLinks = new ArrayList<>();

    ProjectService projectService;

    @Override
    public Response getProjectLink() {
        return Response.ok(projectLinks).build();
    }

    @Override
    public Response createProjectLink(ProjectLinkDTO projectLinkDTO) {
        Optional<Project> project = projectService.findProjectById(projectLinkDTO.projectId());
        
        if (project.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("project not found").build();
        }

        ProjectLink projectLink = ProjectLinkDTO.createProjectLink(projectLinkDTO, project.get());
        projectLinks.add(projectLink);
        return Response.status(Response.Status.CREATED).entity(projectLinks).build();
    }

    @Override
    public Response deleteProjectLink(Long id) {
        Optional<ProjectLink> linkToDelete = projectLinks.stream().filter(projectLinks -> projectLinks.getId().equals(id)).findFirst();

        boolean removed = false;
        if (linkToDelete.isPresent()) {
            removed = projectLinks.remove(linkToDelete.get());
        }
        if (removed) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
}
