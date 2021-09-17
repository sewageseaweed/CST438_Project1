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

    @Query("SELECT * FROM tblUserQuotes WHERE userID = :userId")
    List<UserQuotesEntity> getUserFavorites(int userId);

    @Insert
    void insertFavorite(UserQuotesEntity... userQuote);

    @Delete
    void delete(UserQuotesEntity quote);

    @Query("DELETE FROM tblUserQuotes WHERE userID = :userId")
    void deleteUserFavorites(int userId);

    @Query("DELETE FROM tblUserQuotes")
    void deleteAllFavorites();
}
