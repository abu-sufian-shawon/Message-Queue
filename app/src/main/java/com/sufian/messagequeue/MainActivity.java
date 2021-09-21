package com.sufian.messagequeue;

import static com.sufian.messagequeue.ExampleHandler.TASK_A;
import static com.sufian.messagequeue.ExampleHandler.TASK_B;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private final ExampleLooperThread looperThread = new ExampleLooperThread();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btnStart);

        Button btnStop = findViewById(R.id.btnStop);

        Button btnTaskA = findViewById(R.id.btnTaskA);

        Button btnTaskB = findViewById(R.id.btnTaskB);

        btnStart.setOnClickListener(v->startThread());

        btnStop.setOnClickListener(v->stopThread());

        btnTaskA.setOnClickListener(v->taskA());

        btnTaskB.setOnClickListener(v->taskB());

    }

    private void startThread(){
        looperThread.start();
    }

    private void stopThread(){
        looperThread.looper.quit();
    }

    private void taskA(){
        
        Message msg = Message.obtain();
        msg.what = TASK_B;
        looperThread.handler.sendMessage(msg);

        /*Handler threadHandler = looperThread.handler;
        threadHandler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Log.d(TAG, "run: " + i);
                    SystemClock.sleep(1000);
                }
            }
        });*/

    }

    private void taskB() {
        Message msg = Message.obtain();
        msg.what = TASK_A;
        looperThread.handler.sendMessage(msg);
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {

        }
    }
}