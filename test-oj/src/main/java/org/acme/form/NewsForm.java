package org.acme.form;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class NewsForm {
    private String name;

    @PartType("application/octet-stream")
    private byte[] image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
