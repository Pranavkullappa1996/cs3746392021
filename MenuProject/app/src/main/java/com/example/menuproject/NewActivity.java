package com.example.menuproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        TextView tv=(TextView)findViewById(R.id.textView);
        tv.setText("Hello Pranav Kullappa");
    }
}