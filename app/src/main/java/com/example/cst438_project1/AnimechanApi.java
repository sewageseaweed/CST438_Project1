package com.example.cst438_project1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AnimechanApi {
    /** returns 10 random anime quotes from API */
    @GET("quotes")
    Call<List<Quote>> getRandomQuotes();

    /** returns anime quotes by anime title from API */
    @GET("quotes/anime")
    Call<List<Quote>> getQuotesByAnime(@Query("title") String anime);

    /** returns anime quotes by character from API */
    @GET("quotes/character")
    Call<List<Quote>> getQuotesByCharacter(@Query("name") String character);

    /** returns all available anime titles from API */
    @GET("available/anime")
    Call<List<String>> getAvailableAnime();
}
