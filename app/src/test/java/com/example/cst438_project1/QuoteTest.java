package com.example.cst438_project1;

import org.junit.Assert;
import org.junit.Before;
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
    public void quoteConstructor_isCorrect() {
        String anime = "Sword Art Online";
        String character = "Kazuto Kirigaya";
        String body = "Whether here or in the real world, you can cry when it hurts. There's no rule that you can't show feelings just because it's a game.";
        Quote quote = new Quote(anime, character, body);

        assertNotNull(quote);
        assertEquals(anime, quote.getAnime());
        assertEquals(character, quote.getCharacter());
        assertEquals(body, quote.getQuote());
    }

    public AnimechanApi buildAnimechanApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://animechan.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(AnimechanApi.class);
    }

    @Test
    public void getRandomQuotes_isCorrect() {
        Call<List<Quote>> call = buildAnimechanApi().getRandomQuotes();

        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if(!response.isSuccessful()) {
                    Log.e("getRandomQuotesTest", "Code: " + response.code());
                    fail(response.message());
                    return;
                }

                List<Quote> quotes = response.body();
                for (Quote quote : quotes) {
                    assertNotNull(quote.getAnime());
                    assertNotNull(quote.getCharacter());
                    assertNotNull(quote.getQuote());
                }

                assertEquals(10, quotes.size());
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.e("getRandomQuotesTest", t.getMessage());
                fail(t.getMessage());
            }
        });
    }

    @Test
    public void getQuoteByAnime_isCorrect(){
        String animeToCheck = "Shingeki no Kyojin";

        Call<List<Quote>> call = buildAnimechanApi().getQuotesByAnime(animeToCheck);

        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if(!response.isSuccessful()) {
                    Log.e("getQuoteByAnimeTest", "Code: " + response.code());
                    fail(response.message());
                    return;
                }

                List<Quote> quotes = response.body();
                for (Quote quote : quotes) {
//                    String content = "";
//                    content += "Anime Title: " + quotes.get(i).getAnime() + "\n";
                    assertTrue(quote.getAnime().equals(animeToCheck));
//                    content += "Character: " + quotes.get(i).getCharacter() + "\n";
//                    content += "Quote: " + quotes.get(i).getQuote() + "\n\n";
                }

                assertTrue(quotes.size() <= 10);
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.e("getQuoteByAnimeTest", t.getMessage());
                fail(t.getMessage());
            }
        });
    }

    @Test
    public void getQuoteByCharacter_isCorrect(){
        String characterToCheck = "Lelouch Lamperouge";

        Call<List<Quote>> call = buildAnimechanApi().getQuotesByAnime(characterToCheck);

        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if(!response.isSuccessful()) {
                    Log.e("getQuoteByCharacterTest", "Code: " + response.code());
                    fail(response.message());
                    return;
                }

                List<Quote> quotes = response.body();
                for (Quote quote : quotes) {
//                    String content = "";
//                    content += "Anime Title: " + quotes.get(i).getAnime() + "\n";
                    assertTrue(quote.getCharacter().equals(characterToCheck));
//                    content += "Character: " + quotes.get(i).getCharacter() + "\n";
//                    content += "Quote: " + quotes.get(i).getQuote() + "\n\n";
                }

                assertTrue(quotes.size() <= 10);
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.e("getQuoteByCharacterTest", t.getMessage());
                fail(t.getMessage());
            }
        });
    }
}
