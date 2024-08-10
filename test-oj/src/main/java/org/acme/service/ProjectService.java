package org.acme.service;

import java.util.Optional;

import org.acme.dto.ProjectDTO;
import org.acme.model.Project;

import jakarta.ws.rs.core.Response;

public interface ProjectService {
    Response getProject();

    Response createProject(ProjectDTO projectDTO);

    Response deleteProject(Long id);

    Optional<Project> findProjectById(Long id);
}
