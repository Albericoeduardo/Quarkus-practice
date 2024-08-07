package org.acme.service;

import org.acme.model.Project;

import jakarta.ws.rs.core.Response;

public interface ProjectService {
    Response getProject();

    Response createProject(Project newProject);

    Response deleteProject(Long id);
}
