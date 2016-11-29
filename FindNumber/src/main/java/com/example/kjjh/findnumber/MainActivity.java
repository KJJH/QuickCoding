package com.example.kjjh.findnumber;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText NumText;       // 숫자를 받아올 EditText
    TextView ShowText;      // 추측한 숫자를 보여줄 TextView
    Button BtSend, BtBig, BtSmall, BtBingo;

    String strNum;          // EditText에서 받아온 숫자를 저장할 변수
    int number;             // String으로 받아온 숫자를 Int형으로 변환하여 저장할 변수
    int guessNum;           // 추측한 숫자를 저장할 변수
    int left = 1;
    int right = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumText = (EditText)findViewById(R.id.editText);
        ShowText = (TextView)findViewById(R.id.textView2);
        BtSend = (Button)findViewById(R.id.button1);
        BtBig = (Button)findViewById(R.id.button2);
        BtSmall = (Button)findViewById(R.id.button3);
        BtBingo = (Button)findViewById(R.id.button4);


        // Button1(SEND)을 눌렀을 때
        BtSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNum = NumText.getText().toString();  // 값을 받아오고
                number = Integer.parseInt(strNum);      // int형으로 변환!

                Toast.makeText(getApplicationContext(), "숫자가 저장되었습니다", Toast.LENGTH_LONG).show();

                guessNum = (int)(Math.random()*100)+1;      // 1~100까지의 숫자 중 랜덤으로 한 숫자 저장
                ShowText.setText("Your Number is " + guessNum + "?!");
            }
        });

        // Button2(BIGGER)를 눌렀을 때
        BtBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left = ++guessNum;
                guessNum = (left + right) / 2;    // guessNum보다 큰 수여야 하므로
                ShowText.setText("Your Number is " + guessNum + "?!");
            }
        });

        // Button3(SMALLER)를 눌렀을 때
        BtSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                right = --guessNum;
                guessNum = (left + right) / 2;    // guessNum보다 작은 수여야 하므로
                ShowText.setText("Your Number is " + guessNum + "?!");
            }
        });

        // Button4(BINGO)를 눌렀을 때
        BtBingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "정답입니다!", Toast.LENGTH_LONG).show();
                //ShowText.setText("Your Number is " + guessNum + "!!");

                // 숫자의 색을 바꿔주기 위한 코드
                SpannableStringBuilder builder = new SpannableStringBuilder("Your Number is " + guessNum + "!!");
                builder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF5675")), 0, builder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                ShowText.setText(builder);

                NumText.setText("");    // 다음에 입력하기 쉽게 하기 위해
                left = 1;
                right = 100;    // 초기화
            }
        });
    }
}