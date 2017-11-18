package com.example.pedro.troopersapp.model;

/**
 * Created by Pedro on 18/11/2017.
 */

public class Trooper {

    private int id;
    private String name;
    private String description;
    private String imageUrl;
    private Affiliation affiliation;

    public Trooper(int id, String name, String description, String imageUrl, Affiliation affiliation) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.affiliation = affiliation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }
}
