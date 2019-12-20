package com.example.a30259.handler;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int UPDATE = 1;

    int i = 0;

    Button button;

    private Handler handler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {

                case UPDATE:
                    i = i + 1;
                    Toast.makeText(MainActivity.this,String.valueOf(i),Toast.LENGTH_SHORT).show();
                    handler.sendEmptyMessageDelayed(UPDATE,1000);
                    break;

            }
        }
    };




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    //@Override
                    public void run() {

                        handler.sendEmptyMessage(UPDATE);

                    }

                }).start();

            }
        });
    }
}
