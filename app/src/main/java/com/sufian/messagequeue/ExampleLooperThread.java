package com.sufian.messagequeue;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class ExampleLooperThread extends Thread {
    private static final String TAG = "ExampleLooperThread";

    public Handler handler; // define Handler
    public Looper looper;   // define Looper


    @Override
    public void run() {
        Looper.prepare();    // prepare Looper

        looper = Looper.myLooper();     // init Looper object

        handler = new ExampleHandler(looper);     // set handler for current looper

        Looper.loop();  // loop looper thread

        Log.d(TAG, "run: End of run");  // on finished thread
    }
}
