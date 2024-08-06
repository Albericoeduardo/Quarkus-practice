package org.acme.entity;

import java.net.URL;

public class ProjectLinks {
    private Long id;
    private String type;
    private URL url;
    
    //@ManyToOne
    //@JoinColumn(name = "id")
    private Projects project;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public URL getUrl() {
        return url;
    }
    public void setUrl(URL url) {
        this.url = url;
    }
    public Projects getProject() {
        return project;
    }
    public void setProject(Projects project) {
        this.project = project;
    }
}
