package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

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

        RecyclerView recyclerView = findViewById(R.id.quoteFeedByAnime_recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager((this)));

        final QuoteAdapter adapter = new QuoteAdapter();

        recyclerView.setAdapter(adapter);
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, QuoteFeedByAnimeActivity.class);

        return intent;
    }

//    private List<String> getAnimeTitles() {
//        Call<List<String>> call = QuoteFeedActivity.buildAnimechanApi().getAvailableAnime();
//        List<String> animeTitles;
//
//        call.enqueue(new Callback<List<String>>() {
//            @Override
//            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
//                if(!response.isSuccessful()) {
//                    Log.e(ACTIVITY_LABEL, "onResponse: getAnimeTitles: Code: " + response.code());
//                    return;
//                }
//
//                 animeTitles = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<List<String>> call, Throwable t) {
//                Log.e(ACTIVITY_LABEL, "onFailure: getAnimeTitles: Code: " + t.getMessage());
//            }
//        });
//        return animeTitles;
//    }
}