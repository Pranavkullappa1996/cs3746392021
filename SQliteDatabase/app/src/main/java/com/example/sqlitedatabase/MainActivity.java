package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText college;
    StudentDatabase myData;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.edit1);
        college = (EditText)findViewById(R.id.edit2);

        myData = new StudentDatabase(this);

    }

    public void doSave(View view) {
      myData.insertData(name.getText().toString(),college.getText().toString());
    }

    public void DoLoad(View view) {
        myData.getAll();
    }
}