package com.example.cst438_project1;

import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("id")
    private String mId;

    @SerializedName("items: volumeInfo: title")
    private String mTitle;

    @SerializedName("items: volumeInfo: authors")
    private String[] mAuthors;

    public Book(String id, String title, String[] authors){
        mId = id;
        mTitle = title;
        mAuthors = authors;
    }

    public String getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String[] getmAuthors() {
        return mAuthors;
    }
}
