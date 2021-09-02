package com.example.cst438_project1;

import com.google.gson.annotations.SerializedName;

public class Book {
    private String id;

    @SerializedName("items: volumeInfo: title")
    private String title;

    @SerializedName("items: volumeInfo: authors")
    private String[] authors;

    public Book(String id, String title, String[] authors){
        this.id = id;
        this.title = title;
        this.authors = authors;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }
}
