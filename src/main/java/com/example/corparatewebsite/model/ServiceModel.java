package com.example.corparatewebsite.model;

public class ServiceModel {

    private String title;
    private String description;

    public ServiceModel() {
    }

    public ServiceModel(String title, String description) {
        this.title = title;
        this.description = description;
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