package com.example.cst438_project1;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.cst438_project1.database.AppDatabase;
import com.example.cst438_project1.database.UserQuotesEntity;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class UserQuotesInstrumentedTest {
    Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    AppDatabase appDB = AppDatabase.getDbInstance(appContext);
    int id1 = 998;
//    int id2 = 999;

    public void useAppContext() {
        // Context of the app under test.
        appDB.userQuotes().deleteAllFavorites();

        int userId = id1;
        UserQuotesEntity quote = new UserQuotesEntity(userId,"One Piece", "Luffy D. Monkey", "I will be the king of pirates");
        appDB.userQuotes().insertFavorite(quote);
    }

    @Test
    public void checkDBSize(){
        useAppContext();
        int userId = id1;
        Log.d("UserQuotesInstrumentedTest", "checkDBSize: " + appDB.userQuotes().getAllFavorites().size());
        Log.d("UserQuotesInstrumentedTest", "checkDBSize: " + appDB.userQuotes().getAllFavorites().toString());

//        assertEquals(1, appDB.userQuotes().getUserFavorites(userId).size());
        assertEquals(1, appDB.userQuotes().getAllFavorites().size());
        /** currently fails as the DB does not start from scratch on app startup */
    }

    @Test
    public void checkInsert(){
//        useAppContext();
        int userId = id1;

        UserQuotesEntity quote = new UserQuotesEntity(userId,"Naruto", "Naruto Uzumaki", "I will be Hokage, believe it!");
        appDB.userQuotes().insertFavorite(quote);

        assertEquals(2, appDB.userQuotes().getAllFavorites().size());
//        assertEquals(1, appDB.userQuotes().getUserFavorites(userId).size());
//        assertEquals(1,appDB.userQuotes().getUserFavorites(id1).size());
    }

    @Test
    public void checkDelete(){
//        useAppContext();
        int userId = id1;

        UserQuotesEntity quote = new UserQuotesEntity(userId,"Naruto", "Naruto Uzumaki", "I will be Hokage, believe it!");
//        appDB.userQuotes().insertFavorite(quote);
//        assertEquals(2, appDB.userQuotes().getAllFavorites().size());

        appDB.userQuotes().delete(quote);
        assertEquals(1, appDB.userQuotes().getAllFavorites().size());
    }
}