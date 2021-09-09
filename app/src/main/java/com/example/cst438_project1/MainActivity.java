package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText name;
    EditText email;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UE uE = new UE();
                uE.setUsername(username.getText().toString());
                uE.setPassword(password.getText().toString());
                uE.setName(name.getText().toString());
                uE.setEmail(email.getText().toString());
                if (uE.getUsername().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a username", Toast.LENGTH_SHORT).show();
                }
                else if(uE.getPassword().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_SHORT).show();
                }
                else if(uE.getName().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT).show();
                }
                else if(uE.getEmail().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter an email", Toast.LENGTH_SHORT).show();
                }
                else {
                    UserDatabase uD = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDAO userDAO = uD.userDAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDAO.registerUser(uE);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User registered successfully", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                }
            }
        });
    }
}