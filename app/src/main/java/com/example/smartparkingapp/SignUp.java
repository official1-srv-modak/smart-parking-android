package com.example.smartparkingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup); // Set your sign-up layout XML here

        Button nextButton = findViewById(R.id.btnSignUp);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SignUp.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}

