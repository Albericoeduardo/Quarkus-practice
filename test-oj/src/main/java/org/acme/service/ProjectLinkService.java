package org.acme.service;

import org.acme.entity.ProjectLink;

import jakarta.ws.rs.core.Response;

public interface ProjectLinkService {
    Response getProjectLink();

    Response createProjectLink(ProjectLink newProjectLink);

    Response deleteProjectLink(Long id);
}
