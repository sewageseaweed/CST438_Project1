package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteFeedByAnimeActivity extends AppCompatActivity{
    public static final String ACTIVITY_LABEL = "QUOTE_FEED_BY_ANIME_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_feed_by_anime);

        RecyclerView recyclerView = findViewById(R.id.quoteFeedByAnime_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        final QuoteAdapter quoteAdapter = new QuoteAdapter();
        recyclerView.setAdapter(quoteAdapter);

        // set anime titles into spinner
        Spinner animeSpinner = findViewById(R.id.quoteFeedByAnime_spinner);
        ArrayAdapter<CharSequence> animeAdapter = ArrayAdapter.createFromResource(this, R.array.anime, android.R.layout.simple_spinner_item);
        animeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        animeSpinner.setAdapter(animeAdapter);

        // on spinner selection, update recycler with relevant quotes
        animeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedAnime = animeSpinner.getSelectedItem().toString();
                getQuotesByAnime(quoteAdapter, selectedAnime);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Button btn10rand = findViewById(R.id.quoteFeedByAnime_button_10random);
        btn10rand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("10rand");
            }
        });

        final Button btnByCharacter = findViewById(R.id.quoteFeedByAnime_button_searchByCharacter);
        btnByCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("byCharacter");
            }
        });

        final Button btnSignOut = findViewById(R.id.quoteFeedByAnime_button_btnSignOut);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("signOut");
            }
        });
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, QuoteFeedByAnimeActivity.class);

        return intent;
    }

    public void nextActivity(String choice) {
        Intent intent = new Intent();

        if (choice.equals("10rand")) {
            intent = QuoteFeedActivity.getIntent(getApplicationContext());
        } else if (choice.equals("byCharacter")) {
            intent = QuoteFeedByCharacterActivity.getIntent(getApplicationContext());
        } else if (choice.equals("signOut")) {
            intent = MainActivity.getIntent(getApplicationContext());
        }

        startActivity(intent);
    }

    /** update the quotes in the recycler view based on anime title given to API call */
    private void getQuotesByAnime(QuoteAdapter quoteAdapter, String anime) {
        Call<List<Quote>> call = QuoteFeedActivity.buildAnimechanApi().getQuotesByAnime(anime);

        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if (!response.isSuccessful()) {
                    Log.e(ACTIVITY_LABEL, "onResponse: getQuotesByAnime: Code: " + response.code());
                    return;
                }

                List<Quote> quotes = response.body();
                quoteAdapter.setQuotes(quotes);
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.e(ACTIVITY_LABEL, "onFailure: getQuotesByAnime: Code: " + t.getMessage());
            }
        });
    }
}