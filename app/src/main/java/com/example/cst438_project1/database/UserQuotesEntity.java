package com.example.cst438_project1.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblUserQuotes")
public class UserQuotesEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "userID")
    private int userID;
    /**
     * Title: Is the title of the anime
     * charName: Is the character name.
     * quote: Is the quote.
     */
    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "charName")
    private String charName;

    @ColumnInfo(name = "quote")
    private String quote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public UserQuotesEntity(int userID, String title, String charName, String quote){
        this.userID = userID;
        this.title = title;
        this.charName = charName;
        this.quote = quote;
    }

}
