package com.ltdd.btthgk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView tv = (TextView) findViewById(R.id.detailtitle);
        Intent intent= getIntent();
        tv.setText(intent.getStringExtra("dulieu"));
    }
}