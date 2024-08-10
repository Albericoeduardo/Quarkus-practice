package org.acme.dto;

import java.net.URL;

import org.acme.model.Project;
import org.acme.model.ProjectLink;

public record ProjectLinkDTO(
    Long id,
    String type,
    URL url,
    Long projectId
) {
    public static ProjectLink createProjectLink(ProjectLinkDTO projectLinkDTO, Project project) {
        ProjectLink projectLink = new ProjectLink();

        projectLink.setId(projectLinkDTO.id());
        projectLink.setType(projectLinkDTO.type());
        projectLink.setUrl(projectLinkDTO.url());
        projectLink.setProject(project);  

        return projectLink;
    }
}
