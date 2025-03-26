package com.example.smartparkingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CarDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_details); //set your car details layout XML here

        //Save button logic
        Button saveButton = findViewById(R.id.btnSaveVehicle);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //logic to save the car details
            }
        });

        //back button to return to the previous activity
        Button backButton = findViewById(R.id.btnBack);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}

