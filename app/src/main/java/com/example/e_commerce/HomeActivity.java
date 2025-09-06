package com.example.e_commerce;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvWelcome = findViewById(R.id.tvWelcome);

        String username = getIntent().getStringExtra("username");
        tvWelcome.setText("Welcome, " + username + "!");
    }
}
