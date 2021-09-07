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
    @Before
    public void useAppContext() {
        // Context of the app under test.
        UserQuotesEntity quote = new UserQuotesEntity(1,"One Piece", "Luffy D. Monkey", "I will be the king of pirates");
        appDB.userquotes().insertFavorite(quote);
    }

    @Test
    public void checkDBSize(){
        assertEquals(1, appDB.userquotes().getAllFavorites().size());
    }

    @Test
    public void checkInsert(){
        UserQuotesEntity quote = new UserQuotesEntity(2,"Naruto", "Naruto Uzumaki", "I will be Hokage, believe it!");
        appDB.userquotes().insertFavorite(quote);
        assertEquals(2, appDB.userquotes().getAllFavorites().size());
    }

    @Test
    public void checkDelete(){
        appDB.userquotes().delete(new UserQuotesEntity(2,"Naruto", "Naruto Uzumaki", "I will be Hokage, believe it!"));
        assertEquals(1, appDB.userquotes().getAllFavorites().size());
    }
}