package com.example.cst438_project1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDAO {
    @Insert
    void registerUser(UE uE);

    @Query("select * from users where username=(:username) and password=(:password)")
    UE login(String username, String password);

    @Query("select username from users where id=(:userId)")
    String getUsername(int userId);
}
