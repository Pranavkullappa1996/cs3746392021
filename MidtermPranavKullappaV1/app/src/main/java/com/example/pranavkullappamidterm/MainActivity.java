package com.example.pranavkullappamidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView output;
    EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=(EditText) findViewById(R.id.miles);
        output=(TextView)findViewById(R.id.textView);
        Button convert=(Button)findViewById(R.id.button);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String miles=input.getText().toString();
                try {
                    float inp = Float.parseFloat(miles);
                    float oup=(float)(inp*1.609);
                    output.setText(oup + "kms");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    output.setText("please enter valid miles");
                }


            }
        });

        // input.setOn
    }
}