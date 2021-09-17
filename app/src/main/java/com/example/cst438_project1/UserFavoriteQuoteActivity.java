package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.cst438_project1.database.AppDatabase;
import com.example.cst438_project1.database.UserQuotesEntity;

import java.util.List;

public class UserFavoriteQuoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_favorite_quote);

        int userId = getIntent().getIntExtra("userId", -1);

        RecyclerView recyclerView = findViewById(R.id.quoteFeed_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        final QuoteAdapter adapter = new QuoteAdapter();
        recyclerView.setAdapter(adapter);

        /** set the list adapter to view userFavorites*/

        final Button btnSearchByAnime = findViewById(R.id.quoteFeed_button_searchByAnime);
        final Button btnSearchByCharacter = findViewById(R.id.quoteFeed_button_searchByCharacter);
        final Button btnSignOut = findViewById(R.id.quoteFeed_button_btnSignOut);


        btnSearchByAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("byAnime", userId);
            }
        });

        btnSearchByCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("byCharacter", userId);
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("signOut", userId);
            }
        });
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

    private void getUserFavorites(UserQuotesEntityAdapter entityAdapter, int userId) {
        AppDatabase userFavoritesDb = AppDatabase.getDbInstance(this);
        List<UserQuotesEntity> userFavorites = userFavoritesDb.userQuotes().getAllFavorites(userId);

        entityAdapter.setQuotes(userFavorites);
    }
}