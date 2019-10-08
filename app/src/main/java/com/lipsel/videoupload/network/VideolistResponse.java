package com.lipsel.videoupload.network;

import com.google.gson.annotations.SerializedName;

public class VideolistResponse {

    @SerializedName("id")
    private int id;
    @SerializedName("image")
    private String image;
    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

