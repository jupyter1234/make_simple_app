package com.example.dong7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        today = (TextView) findViewById(R.id.textView);
        today.setText(getTime());
    }

    private String getTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd\nhh:mm");
        String getTime = dateFormat.format(date);
        return getTime;
    }
    public void btn1Method(View view){
        Intent intent = new Intent(this, Maincalendar.class);
        startActivity(intent);
    }

    public void btn2Method(View view) {
        Intent intent = new Intent(this, MainMemo.class);
        startActivity(intent);
    }

    public void btn3Method(View view) {
        Intent intent = new Intent(this, MainCalculator.class);
        startActivity(intent);
    }
    }