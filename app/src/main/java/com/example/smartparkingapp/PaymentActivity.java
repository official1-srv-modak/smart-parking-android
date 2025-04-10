package com.example.smartparkingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        // Confirm payment button
        Button confirmPaymentButton = findViewById(R.id.btnConfirmPayment);
        confirmPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner paymentMethodSpinner = findViewById(R.id.spinnerPaymentMethod);
                String selectedMethod = paymentMethodSpinner.getSelectedItem().toString();
                Toast.makeText(PaymentActivity.this, "Payment Successful with " + selectedMethod, Toast.LENGTH_SHORT).show();

                // Navigate to the next screen or finish
                Intent intent = new Intent(PaymentActivity.this, CarDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Cancel payment button
        Button cancelPaymentButton = findViewById(R.id.btnCancelPayment);
        cancelPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the Payment Activity
            }
        });

        // Back Button
        Button backButton = findViewById(R.id.btnBackToDetails);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Navigate back to the previous activity (Car Details)
            }
        });
    }
}
