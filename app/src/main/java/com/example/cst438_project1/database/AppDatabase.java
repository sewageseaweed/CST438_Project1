package com.example.cst438_project1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities  = {UserQuotesEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserQuotesDAO userQuotes();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context){

        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "tblUserQuotes")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
