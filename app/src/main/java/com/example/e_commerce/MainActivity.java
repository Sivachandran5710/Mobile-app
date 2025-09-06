package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClick = findViewById(R.id.btnClick);
        btnClick.setOnClickListener(v -> {
            Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show();
        });
    }
}
