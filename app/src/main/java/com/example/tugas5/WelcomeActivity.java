package com.example.tugas5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private static final String FILE_NAME = "myFile";
    private TextView welcomeUsername;
    private Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeUsername=findViewById(R.id.welcomeUsername);
        btnLogout=findViewById(R.id.btnLogout);

        SharedPreferences sharedPreferences=getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        String username=sharedPreferences.getString("username","Data Not Found");

        welcomeUsername.setText(username);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}