package com.example.cst438_project1;
//testing dao branch
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String ACTIVITY_LABEL = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextActivity() {
        Intent intent = QuoteFeedActivity.getIntent(getApplicationContext());

        startActivity(intent);
    }
}