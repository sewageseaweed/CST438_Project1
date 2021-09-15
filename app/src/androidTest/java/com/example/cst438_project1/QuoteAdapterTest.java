package com.example.cst438_project1;

import static androidx.test.core.app.ActivityScenario.launch;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RunWith(AndroidJUnit4.class)
public class QuoteAdapterTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.cst438_project1", appContext.getPackageName());
    }

//    @Test
//    public void initialBookFeedActivity_isCorrect() {
//        launch(QuoteFeedActivity.class);
//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
//        recyclerView.setHasFixedSize(true);
//
//        final QuoteAdapter adapter = new QuoteAdapter();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://animechan.vercel.app/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        AnimechanApi animechanApi = retrofit.create(AnimechanApi.class);
//
//        Call<List<Quote>> call = animechanApi.getRandomQuotes();
//
//        call.enqueue(new Callback<List<Quote>>() {
//            @Override
//            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
//                if (!response.isSuccessful()) {
//                    Log.e("QuoteTest", "Code: " + response.code());
//                    return;
//                }
//
//                List<Quote> quotes = response.body();
//                adapter.setQuotes(quotes);
//                recyclerView.setAdapter(adapter);
//
//                assertEquals(10, quotes.size());
//            }
//
//            @Override
//            public void onFailure(Call<List<Quote>> call, Throwable t) {
//                Log.e("QuoteTest", t.getMessage());
//            }
//        });
//    }
}
