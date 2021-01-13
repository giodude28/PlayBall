package com.example.playball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class button extends AppCompatActivity {
private Button btnn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        btnn = findViewById(R.id.btn);

        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Countryinfo.gg="Spain";
                Intent s = new Intent(button.this, MainActivity.class);
                startActivity(s);
            }
        });
    }

}