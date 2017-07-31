package com.example.xuq.audiorecord.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.xuq.audiorecord.R;

/**
 * Created by xuq on 2017/7/31.
 */

public class MainActivity extends Activity{
    private static int RECORD_REQUEST_CODE = 0;
    private static final int SUCCESS_RESULT_CODE = 1;
    private static final int FAIL_RESULT_CODE = 2;


    Button btToRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        btToRecord = (Button) findViewById(R.id.bt_toRecord);
        btToRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecordActivity.class);
                startActivityForResult(intent, RECORD_REQUEST_CODE);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECORD_REQUEST_CODE && resultCode == SUCCESS_RESULT_CODE) {
            Bundle datas = data.getExtras();
            String time = datas.getString("time");
            String filePath = datas.getString("filePath");
            btToRecord.setText("已录音，点击重新录音");
        }
        if (requestCode == RECORD_REQUEST_CODE && resultCode == FAIL_RESULT_CODE) {
            btToRecord.setText("未录音，点击录音");
        }
    }


}
