package org.acme.service;

import org.acme.dto.ProjectDTO;
import jakarta.ws.rs.core.Response;

public interface ProjectService {
    Response getProject();

    Response createProject(ProjectDTO projectDTO);

    Response deleteProject(Long id);
}
