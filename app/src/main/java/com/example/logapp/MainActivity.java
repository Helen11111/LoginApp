package com.example.logapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtV1, txtV2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtV1 = findViewById(R.id.txtV1);
        txtV2 = findViewById(R.id.txtV2);
        btn = findViewById(R.id.btn);

        txtV1.setOnClickListener(this);
        txtV2.setOnClickListener(this);
        btn.setOnClickListener(this);

        String str = getIntent().getStringExtra("user");

        txtV1.setText(str);

    }

    @Override
    public void onClick(View v) {
        if(R.id.txtV1 == v.getId()){
            Toast.makeText(this, "Нажали на 1 ТЕКСТ!", Toast.LENGTH_SHORT).show();
        }
        if(R.id.txtV2 == v.getId()){
            Toast.makeText(this, "Нажали на 2 ТЕКСТ!", Toast.LENGTH_SHORT).show();
        }
        if(R.id.btn == v.getId()){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            finish();
        }
    }
}