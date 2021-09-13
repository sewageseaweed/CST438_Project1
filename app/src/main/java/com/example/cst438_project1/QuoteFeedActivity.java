package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuoteFeedActivity extends AppCompatActivity {
    public static final String ACTIVITY_LABEL = "QUOTE_FEED_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_feed);

        RecyclerView recyclerView = findViewById(R.id.quoteFeed_recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager((this)));

        final QuoteAdapter adapter = new QuoteAdapter();

        recyclerView.setAdapter(adapter);
        getRandomQuotes(adapter);
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, QuoteFeedActivity.class);

        return intent;
    }

    private AnimechanApi buildAnimechanApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://animechan.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(AnimechanApi.class);
    }

    private void getRandomQuotes(QuoteAdapter adapter) {
        Call<List<Quote>> call = buildAnimechanApi().getRandomQuotes();

        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if(!response.isSuccessful()) {
                    Log.e(ACTIVITY_LABEL, "onResponse: getRandomQuotes: Code: " + response.code());
                    return;
                }

                List<Quote> quotes = response.body();
                adapter.setQuotes(quotes);
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.e(ACTIVITY_LABEL, "onFailure: getRandomQuotes: Code: " + t.getMessage());
            }
        });
    }
}