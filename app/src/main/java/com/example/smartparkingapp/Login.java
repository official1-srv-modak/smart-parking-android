package com.example.smartparkingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvForgotPassword, tvSignUp;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvSignUp = findViewById(R.id.tvSignUp);
        progressBar = findViewById(R.id.progressBar);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Handle Login Button Click
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        // Handle Sign-Up Text Click
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSignUp();
            }
        });

        // Handle Forgot Password Text Click
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement Forgot Password functionality
                forgotPassword();
            }
        });
    }

    private void loginUser() {
        String email = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        // Basic validation
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(Login.this, "Please enter both email and password.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Show Progress Bar
        progressBar.setVisibility(View.VISIBLE);

        // Firebase Authentication Login
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Hide Progress Bar
                        progressBar.setVisibility(View.GONE);

                        // Navigate to the Main Activity if login is successful
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            // Successfully signed in
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                            finish();  // Finish the Login activity
                        }
                    } else {
                        // Hide Progress Bar
                        progressBar.setVisibility(View.GONE);

                        // If sign-in fails, display a message to the user
                        Toast.makeText(Login.this, "Authentication failed. " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void navigateToSignUp() {
        // Navigate to Sign-Up Activity
        Intent intent = new Intent(Login.this, SignUp.class);
        startActivity(intent);
    }

    private void forgotPassword() {
        String email = etUsername.getText().toString();

        if (email.isEmpty()) {
            Toast.makeText(Login.this, "Please enter your email address.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Send password reset email
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(Login.this, "Password reset email sent.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this, "Failed to send password reset email.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
