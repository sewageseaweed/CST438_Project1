package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class QuoteFeedByAnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_feed_by_anime);
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, QuoteFeedByAnimeActivity.class);

        return intent;
    }
}