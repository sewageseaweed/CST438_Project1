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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteFeedByAnimeActivity extends AppCompatActivity {
    public static final String ACTIVITY_LABEL = "QUOTE_FEED_BY_ANIME_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_feed_by_anime);

        // set anime titles into spinner
        Spinner animeSpinner = findViewById(R.id.quoteFeedByAnime_spinner);
        ArrayAdapter<CharSequence> animeAdapter = ArrayAdapter.createFromResource(this, R.array.anime, android.R.layout.simple_spinner_item);
        animeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        animeSpinner.setAdapter(animeAdapter);

        // set up onSelect for spinner to call getQuotesByAnime(selection)


        RecyclerView recyclerView = findViewById(R.id.quoteFeedByAnime_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        final QuoteAdapter quoteAdapter = new QuoteAdapter();
        recyclerView.setAdapter(quoteAdapter);




        final Button btn10rand = findViewById(R.id.quoteFeedByAnime_button_10random);

        btn10rand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("10rand");
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
        } else {
//            intent = QuoteFeedByCharacterActivity.getIntent(getApplicationContext());
        }

        startActivity(intent);
    }
}