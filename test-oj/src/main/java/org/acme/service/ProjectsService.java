package org.acme.service;

import org.acme.entity.Projects;

import jakarta.ws.rs.core.Response;

public interface ProjectsService {
    Response getProject();

    Response createProject(Projects newProject);

    Response deleteProject(Long id);
}
