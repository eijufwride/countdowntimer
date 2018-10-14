package com.example.countdowntimer3;

import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

import static android.media.RingtoneManager.*;

public class MainActivity extends AppCompatActivity {

    private TextView timerText;


    private SimpleDateFormat dataFormat =
            new SimpleDateFormat("mm:ss.SSS", Locale.US);

    public long count;
    public long interval = 100;
    public int time = 180000;
    CountDown countDown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 3分= 3x60x1000 = 180000 msec
        final long countNm = 180000;
        // インターバル msec
        //long interval = 10;

        Button startButton = findViewById(R.id.start_button);
        Button stopButton = findViewById(R.id.stop_button);
        Button min3_Btn = findViewById(R.id.min3_Btn);
        Button min4_Btn = findViewById(R.id.min4_Btn);
        Button min5_Btn = findViewById(R.id.min5_Btn);

        timerText = findViewById(R.id.timer);
        timerText.setText(dataFormat.format(time));

        min3_Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // タイマーの時間を3分に設定
                time = 180000;
                timerText.setText(dataFormat.format(time));

            }
        });

        min4_Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // タイマーの時間を4分に設定
                time = 240000;
                timerText.setText(dataFormat.format(time));
            }
        });

        min5_Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // タイマーの時間を5分に設定
                time = 300000;
                timerText.setText(dataFormat.format(time));

            }
        });

        // インスタンス生成
        // CountDownTimer(long millisInFuture, long countDownInterval)


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //開始
                countDown = new CountDown(time, interval);
                countDown.start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 中止
                countDown.cancel();
                timerText.setText(dataFormat.format(time));
            }
        });
    }


        class CountDown extends CountDownTimer {

            CountDown(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override
            public void onFinish() {
                // 完了
                timerText.setText(dataFormat.format(0));
            }

            // インターバルで呼ばれる
            @Override
            public void onTick(long millisUntilFinished) {
                // 残り時間を分、秒、ミリ秒に分割
                //long mm = millisUntilFinished / 1000 / 60;
                //long ss = millisUntilFinished / 1000 % 60;
                //long ms = millisUntilFinished - ss * 1000 - mm * 1000 * 60;
                //timerText.setText(String.format("%1$02d:%2$02d.%3$03d", mm, ss, ms));

                timerText.setText(dataFormat.format(millisUntilFinished));

            }
        }

    Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);

    //MediaPlayer player = new MediaPlayer();
//player.setDataSource(context, uri);                   // 音声を設定
//player.setAudioStreamType(AudioManager.STREAM_ALARM); // アラームのボリュームで再生
//player.setLooping(true);                              // ループ再生を設定
//player.prepare();                                     // 音声を読み込み

//player.start(); // 再生
//player.stop();  // 停止

    }
