package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.cst438_project1.database.AppDatabase;
import com.example.cst438_project1.database.UserQuotesEntity;

import java.util.List;

public class UserFavoriteQuoteActivity extends AppCompatActivity {
    public static final String ACTIVITY_LABEL = "USER_FAVORITE_QUOTE_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_favorite_quote);

        int userId = getIntent().getIntExtra("userId", -1);
        Log.d(ACTIVITY_LABEL, "onCreate: userId: " + userId);

        RecyclerView recyclerView = findViewById(R.id.userQuoteFavorite_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        final UserQuotesEntityAdapter adapter = new UserQuotesEntityAdapter();
        recyclerView.setAdapter(adapter);

        /** set the list adapter to view userFavorites*/
        getUserFavorites(adapter,userId);

        final Button btnSearchByAnime = findViewById(R.id.userQuoteFavorite_button_searchByAnime);
        btnSearchByAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("byAnime", userId);
            }
        });

        final Button btnSearchByCharacter = findViewById(R.id.userQuoteFavorite_button_searchByCharacter);
        btnSearchByCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity("byCharacter", userId);
            }
        });

        final Button btnSignOut = findViewById(R.id.userQuoteFavorite_button_btnSignOut);
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
        } else if (choice.equals("10rand")) {
            intent = QuoteFeedActivity.getIntent(getApplicationContext());
        } else if (choice.equals("signOut")) {
            intent = MainActivity.getIntent(getApplicationContext());
        }

        if (!choice.equals("signOut")) {
            intent.putExtra("userId", userId);
        }

        startActivity(intent);
    }

    private void getUserFavorites(UserQuotesEntityAdapter entityAdapter, int userId) {
        Log.d(ACTIVITY_LABEL, "getUserFavorites: begin");
        AppDatabase userFavoritesDb = AppDatabase.getDbInstance(this);
        List<UserQuotesEntity> userFavorites = userFavoritesDb.userQuotes().getAllFavorites(userId);
        Log.d(ACTIVITY_LABEL, "getUserFavorites: userFavorites.size(): " + userFavorites.size());
        Log.d(ACTIVITY_LABEL, "getUserFavorites: userFavorites: " + userFavorites.toString());

        if (userFavorites.size() > 0) {
            entityAdapter.setQuotes(userFavorites);
        } else {
            Toast.makeText(getApplicationContext(), "No Favorites to show", Toast.LENGTH_LONG).show();
        }

    }
}