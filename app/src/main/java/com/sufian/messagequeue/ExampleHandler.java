package com.sufian.messagequeue;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class ExampleHandler extends Handler {
    private static final String TAG = "ExampleHandler";
    public static final int TASK_A = 1;
    public static final int TASK_B = 2;

    public ExampleHandler(Looper looper){
        super(looper);
    }

    /**
     * Handle message by its what filed
     * @param msg Message object
     */
    @Override
    public void handleMessage(@NonNull Message msg) {
        switch (msg.what){
            case TASK_A:
                Log.d(TAG, "handleMessage: Task A executed");
                break;
            case TASK_B:
                Log.d(TAG, "handleMessage: Task B executed");
                break;
        }
    }
}
