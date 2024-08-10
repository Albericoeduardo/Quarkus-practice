package org.acme.model;

import java.util.List;

public class Project {
    private Long id;
    private String image;
    private String title;
    private String description;
    private List<ProjectLink> links;
    
    public Long getId() {
        return id;
    }
    public List<ProjectLink> getLinks() {
        return links;
    }
    public void setLinks(List<ProjectLink> links) {
        this.links = links;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
