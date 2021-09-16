package com.example.cst438_project1;
//testing dao branch
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String ACTIVITY_LABEL = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button testButton = findViewById(R.id.main_button);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to QuoteFeedActivity
                nextActivity();
            }
        });
    }

    public void nextActivity() {
        Intent intent = QuoteFeedActivity.getIntent(getApplicationContext());

        startActivity(intent);
    }
}