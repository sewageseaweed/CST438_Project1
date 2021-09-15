package com.example.cst438_project1.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserQuotesDAO {
    @Query("SELECT * FROM tblUserQuotes")
    List<UserQuotesEntity> getAllFavorites();

    @Insert
    void insertFavorite(UserQuotesEntity... userQuote);

    @Delete
    void delete(UserQuotesEntity quote);
}
