package com.example.cst438_project1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GoogleBooksApi {

    @GET("books/v1/volumes?q=incategories:fantasy&printType=books&maxResult=5")
    Call<List<Book>> getBooks();
}
