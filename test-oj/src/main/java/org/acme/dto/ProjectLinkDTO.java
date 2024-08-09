package org.acme.dto;

import java.net.URL;

import org.acme.model.ProjectLink;

public record ProjectLinkDTO(
    Long id,
    String type,
    URL url
) {
    public static ProjectLink createProjectLink(ProjectLinkDTO projectLinkDTO) {
        ProjectLink projectLink = new ProjectLink();

        projectLink.setId(projectLinkDTO.id());
        projectLink.setType(projectLinkDTO.type());
        projectLink.setUrl(projectLinkDTO.url());

        return projectLink;
    }
}
