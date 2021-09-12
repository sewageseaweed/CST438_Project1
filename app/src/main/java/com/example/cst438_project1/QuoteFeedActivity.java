package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuoteFeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_feed);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
//        recyclerView.setHasFixedSize(true);

        final QuoteAdapter adapter = new QuoteAdapter();

        recyclerView.setAdapter(adapter);
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, QuoteFeedActivity.class);

        return intent;
    }

    public AnimechanApi buildAnimechanApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://animechan.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(AnimechanApi.class);
    }
}