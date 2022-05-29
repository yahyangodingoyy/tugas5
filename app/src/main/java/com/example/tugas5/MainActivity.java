package com.example.tugas5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.ads.mediationtestsuite.activities.HomeActivity;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "myFile";
    private EditText inputUsername, inputPassword;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUsername=findViewById(R.id.inputUsername);
        inputPassword=findViewById(R.id.inputPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        checkBox=findViewById(R.id.checkBox);

        SharedPreferences sharedPreferences=getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");
        String password=sharedPreferences.getString("password","");

        inputUsername.setText(username);
        inputPassword.setText(password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String username=inputUsername.getText().toString();
               String password=inputPassword.getText().toString();

               if(checkBox.isChecked())
               {
                  StoredDataUsingSHaredPref(username,password);
               }
               Intent intent=new Intent(getApplicationContext(),WelcomeActivity.class);
               startActivity(intent);

            }
        });

    }

    private void StoredDataUsingSHaredPref(String username, String password) {

        SharedPreferences.Editor editor=getSharedPreferences(FILE_NAME,MODE_PRIVATE).edit();
        editor.putString("username",username);
        editor.putString("password",password);
        editor.apply();

    }

}