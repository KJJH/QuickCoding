package com.example.kjjh.theresult;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ResultText;
    Button ButtonMin;
    Button ButtonAvg;

    int[] arr = {14, 5, 9, 3, 22, 12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ResultText = (TextView) findViewById(R.id.textView);
        ButtonMin = (Button) findViewById(R.id.bt_min);
        ButtonAvg = (Button) findViewById(R.id.bt_avg);


        // Button1(Minimum)을 눌렀을 때
        ButtonMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int min = arr[0];  // 가장 작은 수를 저장할 변수

                // Find Minimum Number
                for(int i=0; i<arr.length; i++){
                    if(arr[i] < min){
                        min = arr[i];
                    }
                }

                ResultText.setText("The Results : " + min);
            }
        });

        // Button2(Average)를 눌렀을 때
        ButtonAvg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                float avg = 0;

                for(int i=0; i<arr.length; i++)
                    avg += arr[i];
                avg /= arr.length;      // avg = arrSum / arrLength

                java.text.DecimalFormat format = new java.text.DecimalFormat();
                format.applyLocalizedPattern("0.#");        // 소수점 한 자리만

                ResultText.setText("The Results : " + format.format(avg));
            }
        });

    }

}
