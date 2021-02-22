package com.example.menuproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity {
    boolean isMenuVisble=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button phone=(Button)findViewById(R.id.button2);
        Button menu=(Button)findViewById(R.id.button1);
        Button help=(Button)findViewById(R.id.help);
        NavigationView navView=(NavigationView)findViewById(R.id.nav);
        navView.setVisibility(View.INVISIBLE);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HelpActivity.class);
                startActivity(intent);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isMenuVisble)
                {
                    navView.setVisibility(View.INVISIBLE);

                }
                else
                {
                    navView.setVisibility(View.VISIBLE);
                }
                isMenuVisble=!isMenuVisble;


            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phone=new Intent(Intent.ACTION_DIAL);
                phone.setData(Uri.parse("tel:" + "939393988388"));
                startActivity(phone);
            }
        });
        Button smsbutton=(Button)findViewById(R.id.button3);
        smsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sms=new Intent(Intent.ACTION_SEND);
                sms.setData(Uri.parse("smsto:9294983669"));
               // sms.setType(HTTP.PLAIN_TEXT_TYPE);
                sms.putExtra("sms_body", "hello");
                try {
                    startActivity(sms);
                }catch (Exception e){e.printStackTrace();}
            }
        });
        Button webbutton=(Button)findViewById(R.id.button4);
        webbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://portal5.pace.edu/web/home-community/home");
                Intent web = new Intent(Intent.ACTION_VIEW, webpage);
                if (web.resolveActivity(getPackageManager()) != null) {
                    startActivity(web);
                }
            }
        });
        Button mapbutton=(Button)findViewById(R.id.button5);
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(Intent.ACTION_VIEW);
                map.setData(Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway%2C+CA"));
                if (map.resolveActivity(getPackageManager()) != null) {
                    startActivity(map);
                }
            }
        });

        Button shareBut=(Button)findViewById(R.id.button6);
        shareBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share=new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT,"Share the love");
                share.putExtra(Intent.EXTRA_TEXT,"share the love");
                startActivity(Intent.createChooser(share,"Share The Love"));
            }
        });
        Button newActivity=(Button)findViewById(R.id.button7);
        newActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newAct=new Intent(getApplicationContext(),NewActivity.class);
                startActivity(newAct);
            }
        });


    }
}