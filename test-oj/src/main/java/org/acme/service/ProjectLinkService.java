package org.acme.service;

import org.acme.dto.ProjectLinkDTO;

import jakarta.ws.rs.core.Response;

public interface ProjectLinkService {
    Response getProjectLink();

    Response createProjectLink(ProjectLinkDTO projectLinkDTO);

    Response deleteProjectLink(Long id);
}
