package com.example.e_commerce.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.e_commerce.DatabaseHelper;
import com.example.e_commerce.R;

public class LoginActivity extends AppCompatActivity {

    EditText etUserOrEmail, etPassword;
    Button btnLogin;
    TextView tvRegisterLink;   // ✅ correct type for TextView
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_Ecommerce); // your normal theme
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        db = new DatabaseHelper(this);

        etUserOrEmail = findViewById(R.id.etLoginUserOrEmail);
        etPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegisterLink = findViewById(R.id.tvRegisterLink); // ✅ match the XML id

        btnLogin.setOnClickListener(v -> {
            String userOrEmail = etUserOrEmail.getText().toString();
            String pass = etPassword.getText().toString();

            if (userOrEmail.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                boolean success = db.checkUser(userOrEmail, pass);
                if (success) {
                    Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, HomeActivity.class);
                    i.putExtra("username", userOrEmail);
                    startActivity(i);
                } else {
                    Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvRegisterLink.setOnClickListener(v -> {   // ✅ use TextView click
            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
        });
    }
}
