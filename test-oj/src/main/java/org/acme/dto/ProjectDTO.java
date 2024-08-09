package org.acme.dto;

import org.acme.model.Project;

public record ProjectDTO(
    Long id,
    String image,
    String title,
    String description
) {
    public static Project createProject(ProjectDTO projectDTO) {
        Project project = new Project();

        project.setId(projectDTO.id());
        project.setTitle(projectDTO.title());
        project.setDescription(projectDTO.image());
        project.setImage(projectDTO.image());

        return project;
    }
}
