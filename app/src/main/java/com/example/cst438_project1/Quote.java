package com.example.cst438_project1;

public class Quote {
    private String anime;
    private String character;
    private String quote;

    public Quote(String anime, String character, String quote){
        this.anime = anime;
        this.character = character;
        this.quote = quote;
    }

    public String getAnime() {
        return anime;
    }

    public String getCharacter() {
        return character;
    }

    public String getQuote() {
        return quote;
    }
}
