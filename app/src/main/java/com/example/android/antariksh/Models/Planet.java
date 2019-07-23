package com.example.android.antariksh.Models;

/**
 * Created by neha on 7/7/2019.
 */

public class Planet {
    int imageResourceId;
    String title,description;

    public Planet(int imageResourceId, String title, String description) {
        this.imageResourceId = imageResourceId;
        this.title = title;
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
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
