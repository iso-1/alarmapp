package com.example.ryuichi.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.enter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeConf(mhours(), mminutes());
            }
        });


    }


    //ボタンが押された時の処理
    public void onClick(View view){
        Intent intent = new Intent(this, SampleActivity.class);  //インテントの作成
        startActivity(intent);                                 //画面遷移
    }






    //時を取得
    private String mhours() {
        EditText Ehour = (EditText) this.findViewById(R.id.hour);
        String hour = Ehour.getText().toString();
        return hour;
    }

    //分を取得
    private String mminutes() {
        EditText Eminute = (EditText) this.findViewById(R.id.minute);
        String minute = Eminute.getText().toString();
        return minute;
    }

    //設定した時刻を表示
    private void timeConf(String h, String m) {
        TextView confview = (TextView) this.findViewById(R.id.confview);
        confview.setText("設定した時間は　" + h + "：" + m);
    }

    public void timerSet(Calendar calendar) {
        //実行するサービスを指定
        Intent intent = new Intent(getApplicationContext(), messageService.class);
        Context ct = getApplication();
        PendingIntent pendingIntent = PendingIntent.getService(ct, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // AlarmManager の設定・開始
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }


}



        //http://api.openweathermap.org/data/2.5/weather?id=1850147&units=metric&appid=※
        //https://api.openweathermap.org/data/2.5/weather?q={東京}&appid={e129f6c1a9c4966185b5169aeec5a381}

/*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }*/


    /*fun changeTextView(view: View) {
        messageTextView.text = "Hello there!"
    }*/

