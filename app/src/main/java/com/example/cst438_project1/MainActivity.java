package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UE userEntity = new UE();
                userEntity.setUsername(username.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setName(name.getText().toString());
                userEntity.setEmail(email.getText().toString());
                if (userEntity.getUsername().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a username", Toast.LENGTH_SHORT).show();
                }
                else if(userEntity.getPassword().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_SHORT).show();
                }
                else if(userEntity.getName().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT).show();
                }
                else if(userEntity.getEmail().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter an email", Toast.LENGTH_SHORT).show();
                }
                else {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDAO userDAO = userDatabase.userDAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDAO.registerUser(userEntity);
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
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });
    }
}