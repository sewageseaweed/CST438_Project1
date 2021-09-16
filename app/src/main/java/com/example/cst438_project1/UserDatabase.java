package com.example.cst438_project1;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UE.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase{
    private static UserDatabase userDatabase;
    public static synchronized UserDatabase getUserDatabase(Context context){

        if(userDatabase == null) {
            userDatabase = Room.databaseBuilder(context, UserDatabase.class, "users").fallbackToDestructiveMigration().build();
        }
        return userDatabase;
    }
    public abstract UserDAO userDAO();
}