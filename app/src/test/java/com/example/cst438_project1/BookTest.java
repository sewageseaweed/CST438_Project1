package com.example.cst438_project1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookTest {

//    @Test
//    public void booksGet_isCorrect(){
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.googleapis.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        GoogleBooksApi googleBooksApi = retrofit.create(GoogleBooksApi.class);
//
//        Call<List<Book>> call = googleBooksApi.getBooks();
//
//        call.enqueue(new Callback<List<Book>>() {
//            @Override
//            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
//                if(!response.isSuccessful()) {
//                    Log.e("BookTest", "Code: " + response.code());
//                    return;
//                }
//
//                List<Book> books = response.body();
//                for(int i = 0; i < 2; i++) {
//                    String content = "";
//                    content += "ID: " + books.get(i).getmId() + "\n";
//                    content += "Tite: " + books.get(i).getmId() + "\n";
//                    content += "Authors: ";
//                    for(int j = books.get(i).getmAuthors().length - 1; i > -1; i--) {
//                        content += books.get(i).getmAuthors()[j];
//                        if (j - 1 > -1) {
//                            content += ", ";
//                        } else {
//                            content += "\n";
//                        }
//                    }
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Book>> call, Throwable t) {
//                Log.e("BookTest", t.getMessage());
//                fail(t.getMessage());
//            }
//        });
//    }
}
