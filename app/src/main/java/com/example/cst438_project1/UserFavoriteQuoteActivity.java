package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class UserFavoriteQuoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_favorite_quote);
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, UserFavoriteQuoteActivity.class);

        return intent;
    }

    public void nextActivity(String choice, int userId) {
        Intent intent = new Intent();

        if (choice.equals("byAnime")) {
            intent = QuoteFeedByAnimeActivity.getIntent(getApplicationContext());
        } else if (choice.equals("byCharacter")) {
            intent = QuoteFeedByCharacterActivity.getIntent(getApplicationContext());
        } else if (choice.equals("signOut")) {
            intent = MainActivity.getIntent(getApplicationContext());
        }

        intent.putExtra("userId", userId);

        startActivity(intent);
    }
}