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

public class QuoteFeedByCharacterActivity extends AppCompatActivity {
    public static final String ACTIVITY_LABEL = "QUOTE_FEED_BY_CHARACTER_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_feed_by_character);

        RecyclerView recyclerView = findViewById(R.id.quoteFeedByCharacter_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        final QuoteAdapter quoteAdapter = new QuoteAdapter();
        recyclerView.setAdapter(quoteAdapter);

        // set character names into spinner
        Spinner characterSpinner = findViewById(R.id.quoteFeedByCharacter_spinner);
        ArrayAdapter<CharSequence> characterAdapter = ArrayAdapter.createFromResource(this, R.array.characters, android.R.layout.simple_spinner_item);
        characterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        characterSpinner.setAdapter(characterAdapter);

        // set up onSelect for spinner to call getQuotesByAnime(selection)
        characterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedcharacter = characterSpinner.getSelectedItem().toString();
                getQuotesByCharacter(quoteAdapter, selectedcharacter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Button btn10rand = findViewById(R.id.quoteFeedByCharacter_button_10random);
        final Button btnByAnime= findViewById(R.id.quoteFeedByCharacter_button_searchByAnime);

        btn10rand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("10rand");
            }
        });

        btnByAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("byAnime");
            }
        });
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, QuoteFeedByCharacterActivity.class);

        return intent;
    }

    public void nextActivity(String choice) {
        Intent intent = new Intent();

        if (choice.equals("10rand")) {
            intent = QuoteFeedActivity.getIntent(getApplicationContext());
        } else if (choice.equals("byAnime")) {
            intent = QuoteFeedByAnimeActivity.getIntent(getApplicationContext());
        }

        startActivity(intent);
    }

    private void getQuotesByCharacter(QuoteAdapter adapter, String character) {
        Call<List<Quote>> call = QuoteFeedActivity.buildAnimechanApi().getQuotesByCharacter(character);

        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if (!response.isSuccessful()) {
                    Log.e(ACTIVITY_LABEL, "onResponse: getQuotesByCharacter: Code: " + response.code());
                    return;
                }

                List<Quote> quotes = response.body();
                adapter.setQuotes(quotes);
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.e(ACTIVITY_LABEL, "onFailure: getQuotesByCharacter: Code: " + t.getMessage());
            }
        });
    }
}