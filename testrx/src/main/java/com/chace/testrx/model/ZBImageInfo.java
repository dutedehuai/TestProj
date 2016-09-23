package com.chace.testrx.model;

/**
 * Created by chacewang on 16/9/23.
 */
public class ZBImageInfo {
    private String description;
    private String image_url;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "ZBImageInfo{" +
                "description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
