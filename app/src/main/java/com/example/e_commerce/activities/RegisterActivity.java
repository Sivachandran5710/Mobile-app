package com.example.e_commerce.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.e_commerce.DatabaseHelper;
import com.example.e_commerce.R;

public class RegisterActivity extends AppCompatActivity {

    EditText etUsername, etEmail, etPassword, etConfirmPassword;
    Button btnRegister;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        etUsername = findViewById(R.id.etRegUsername);
        etEmail = findViewById(R.id.etRegEmail);
        etPassword = findViewById(R.id.etRegPassword);
        etConfirmPassword = findViewById(R.id.etRegConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> {
            String user = etUsername.getText().toString();
            String email = etEmail.getText().toString();
            String pass = etPassword.getText().toString();
            String confirm = etConfirmPassword.getText().toString();

            if (user.isEmpty() || email.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
            } else if (!pass.equals(confirm)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                boolean success = db.registerUser(user, email, pass);
                if (success) {
                    Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                    finish(); // go back to login
                } else {
                    Toast.makeText(this, "User already exists!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
