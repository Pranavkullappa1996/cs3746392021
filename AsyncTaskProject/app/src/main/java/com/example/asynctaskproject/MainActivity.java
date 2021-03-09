package com.example.asynctaskproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView tv;
    private static final String TEXT_STATE = "currentText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        if(imageView==null)
        {
            Log.e("image","null");}
        Button b=(Button)findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTask(imageView,tv);
            }
        });
    }



    public void startTask(View i,View t) {
       // mTextView.setText(R.string.napping);

        new AsyncTask1((ImageView)i,(TextView)t).execute();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}