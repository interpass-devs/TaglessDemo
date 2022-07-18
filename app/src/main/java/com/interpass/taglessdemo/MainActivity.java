package com.interpass.taglessdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ticket_layout;
    private Button btn_put, btn_on_board, btn_stop;
    private EditText et_cardnum;
    private TextView tv_cardnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ticket_layout = (LinearLayout) findViewById(R.id.ticket_layout);
        et_cardnum = (EditText) findViewById(R.id.et_cardnum);
        btn_put = (Button) findViewById(R.id.btn_put);
        tv_cardnum = (TextView) findViewById(R.id.tv_cardnum);
        btn_on_board = (Button) findViewById(R.id.on_board);
        btn_stop = (Button) findViewById(R.id.stop);

        btn_put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_cardnum.getText().toString().length() == 4) {
                    tv_cardnum.setVisibility(View.VISIBLE);
                    tv_cardnum.setText(et_cardnum.getText().toString());
                    et_cardnum.setText("");
                    ticket_layout.setBackgroundResource(R.drawable.pink_round_background);
                }else {
                    tv_cardnum.setVisibility(View.GONE);
                    et_cardnum.setText("");
                    ticket_layout.setBackgroundResource(R.drawable.grey_round_background);
                    Toast.makeText(MainActivity.this, "잘못 입력하셨습니다\n4자리를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //입력버튼
        btn_put.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.orange_selected_btn);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.orange_gradi_btn);
                }
                return false;
            }
        });

        //승차버튼
        btn_on_board.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.green_selected_btn);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.green_gradi_btn);
                }
                return false;
            }
        });

        //정지버튼
        btn_stop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.grey_selected_btn);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.grey_gradi_btn);
                }
                return false;
            }
        });
    }
}