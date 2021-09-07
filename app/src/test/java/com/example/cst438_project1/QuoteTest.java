package com.example.cst438_project1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuoteTest {

    @Test
    public void getRandomQuotes_isCorrect(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://animechan.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimechanApi animechanApi = retrofit.create(AnimechanApi.class);

        Call<List<Quote>> call = animechanApi.getRandomQuotes();

        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if(!response.isSuccessful()) {
                    Log.e("QuoteTest", "Code: " + response.code());
                    return;
                }

                List<Quote> quotes = response.body();
                for(int i = 0; i < 2; i++) {
                    String content = "";
                    content += "Anime Title: " + quotes.get(i).getAnime() + "\n";
                    content += "Character: " + quotes.get(i).getCharacter() + "\n";
                    content += "Quote: " + quotes.get(i).getQuote() + "\n\n";
                }

                assertEquals(10, quotes.size());
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.e("QuoteTest", t.getMessage());
                fail(t.getMessage());
            }
        });
    }

    @Test
    public void getQuoteByAnime_isCorrect(){
        String animeToCheck = "Shingeki no Kyojin";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://animechan.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimechanApi animechanApi = retrofit.create(AnimechanApi.class);

        Call<List<Quote>> call = animechanApi.getQuotesByAnime(animeToCheck);

        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if(!response.isSuccessful()) {
                    Log.e("QuoteTest", "Code: " + response.code());
                    return;
                }

                List<Quote> quotes = response.body();
                for(int i = 0; i < 2; i++) {
                    String content = "";
                    content += "Anime Title: " + quotes.get(i).getAnime() + "\n";
                    assertTrue(quotes.get(i).getAnime().equals(animeToCheck));
                    content += "Character: " + quotes.get(i).getCharacter() + "\n";
                    content += "Quote: " + quotes.get(i).getQuote() + "\n\n";
                }

                assertTrue(quotes.size() <= 10);
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.e("QuoteTest", t.getMessage());
                fail(t.getMessage());
            }
        });
    }
}
