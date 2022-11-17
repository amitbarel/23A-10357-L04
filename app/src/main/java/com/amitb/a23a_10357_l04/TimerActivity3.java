package com.amitb.a23a_10357_l04;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

public class TimerActivity3 extends AppCompatActivity {

    final int DELAY = 1000;

    MaterialTextView timer_LBL_time;
    ExtendedFloatingActionButton timer_FAB_start;
    ExtendedFloatingActionButton timer_FAB_stop;
    long startTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        findViews();
        initViews();
    }

    private void updateTimerUI() {
        long millis = System.currentTimeMillis() - startTime;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        int hours = minutes / 60;
        minutes = minutes % 60;
        hours %= 24;

        timer_LBL_time.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    private void stopTimer() {
        countDownTimer.cancel();
    }

    private CountDownTimer countDownTimer;

    private void startTimer() {
        startTime = System.currentTimeMillis();
        countDownTimer = new CountDownTimer(99999999, DELAY) {
            @Override
            public void onTick(long l) {
                Log.d("TimerCount B:", Thread.currentThread().getName() + " " + System.currentTimeMillis());
                updateTimerUI();
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }

    private void findViews() {
        timer_FAB_stop = findViewById(R.id.timer_FAB_stop);
        timer_FAB_start = findViewById(R.id.timer_FAB_start);
        timer_LBL_time = findViewById(R.id.timer_LBL_time);
    }

    private void initViews() {
        timer_FAB_start.setOnClickListener(v -> startTimer());
        timer_FAB_stop.setOnClickListener(v -> stopTimer());
    }
}