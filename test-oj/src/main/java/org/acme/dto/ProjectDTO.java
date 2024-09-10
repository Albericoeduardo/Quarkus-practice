package org.acme.dto;

import org.acme.model.Project;

public record ProjectDTO(
    Long id,
    String imageUrl,
    String title,
    String description
) {
    public static Project createProject(ProjectDTO projectDTO) {
        Project project = new Project();

        project.setId(projectDTO.id());
        project.setTitle(projectDTO.title());
        project.setDescription(projectDTO.description());
        project.setImage(projectDTO.imageUrl());

        return project;
    }
}
