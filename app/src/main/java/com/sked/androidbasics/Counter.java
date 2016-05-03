package com.sked.androidbasics;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class Counter extends Activity {
    Random manuRandom = new Random();
    Handler manuHandler = new Handler();
    Button random;
    TextView counter;
    private int x;
    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        counter = (TextView) findViewById(R.id.countText);
        random = (Button) findViewById(R.id.counterbtn);
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomize();
            }
        });
    }

    public void randomize() {
        Runnable manuRunnable = new Runnable() {
            @Override
            public void run() {
                generate();

            }
        };
        new Thread(manuRunnable).start();

    }

    private void generate() {
        for (int i = 0; i < 40; i++) {
            x = manuRandom.nextInt(100) + 1;
            number = String.valueOf(x);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            manuHandler.post(new Runnable() {
                @Override
                public void run() {
                    counter.setText(number);
                }
            });


        }

    }
}
