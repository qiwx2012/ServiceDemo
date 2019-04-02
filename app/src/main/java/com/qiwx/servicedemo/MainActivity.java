package com.qiwx.servicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent start=new Intent(MainActivity.this,MyService.class);
                Intent start=new Intent(MainActivity.this,MyIntentService.class);
                startService(start);
            }
        });
        findViewById(R.id.btnStop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent start=new Intent(MainActivity.this,MyService.class);
                Intent start=new Intent(MainActivity.this,MyIntentService.class);
                stopService(start);
            }
        });
        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent start=new Intent(MainActivity.this,MyService.class);
                Intent start=new Intent(MainActivity.this,FirstActivity.class);
                startActivity(start);
            }
        });
    }
}
