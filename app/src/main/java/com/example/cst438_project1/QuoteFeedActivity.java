package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

        final Button btnSearchByAnime = findViewById(R.id.quoteFeed_button_searchByAnime);
        final Button btnSearchByCharacter = findViewById(R.id.quoteFeed_button_searchByCharacter);
        final Button btnSignOut = findViewById(R.id.quoteFeed_button_btnSignOut);

        btnSearchByAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("byAnime");
            }
        });

        btnSearchByCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("byCharacter");
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("signOut");
            }
        });
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, QuoteFeedActivity.class);

        return intent;
    }

    public void nextActivity(String choice) {
        Intent intent = new Intent();

        if (choice.equals("byAnime")) {
            intent = QuoteFeedByAnimeActivity.getIntent(getApplicationContext());
        } else if (choice.equals("byCharacter")) {
            intent = QuoteFeedByCharacterActivity.getIntent(getApplicationContext());
        } else if (choice.equals("signOut")) {
            intent = MainActivity.getIntent(getApplicationContext());
        }

        startActivity(intent);
    }


    /** return a retrofit base for Call items for animechan API */
    public static AnimechanApi buildAnimechanApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://animechan.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(AnimechanApi.class);
    }

    /** update the quotes in the recycler view based on API call */
    private void getRandomQuotes(QuoteAdapter quoteAdapter) {
        Call<List<Quote>> call = buildAnimechanApi().getRandomQuotes();

        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if(!response.isSuccessful()) {
                    Log.e(ACTIVITY_LABEL, "onResponse: getRandomQuotes: Code: " + response.code());
                    return;
                }

                List<Quote> quotes = response.body();
                quoteAdapter.setQuotes(quotes);
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.e(ACTIVITY_LABEL, "onFailure: getRandomQuotes: Code: " + t.getMessage());
            }
        });
    }


}