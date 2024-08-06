package org.acme.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.entity.ProjectLink;
import org.acme.service.ProjectLinkService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ProjectLinkServiceImpl implements ProjectLinkService {

    public List<ProjectLink> projectLinks = new ArrayList<>();

    @Override
    public Response getProjectLink() {
        return Response.ok(projectLinks).build();
    }

    @Override
    public Response createProjectLink(ProjectLink newProjectLink) {
        projectLinks.add(newProjectLink);
        return Response.status(Response.Status.CREATED).entity(newProjectLink).build();
    }

    @Override
    public Response deleteProjectLink(Long id) {
        Optional<ProjectLink> linkToDelete = projectLinks.stream().filter(projectLinks -> projectLinks.getId().equals(id)).findFirst();

        boolean removed = false;
        if (linkToDelete.isPresent()) {
            removed = projectLinks.remove(linkToDelete.get());
        }
        if (removed) {
            Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
}
