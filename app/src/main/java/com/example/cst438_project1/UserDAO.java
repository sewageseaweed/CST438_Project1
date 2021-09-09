package com.example.cst438_project1;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserDAO {
    @Insert
    void registerUser(UE uE);
}
