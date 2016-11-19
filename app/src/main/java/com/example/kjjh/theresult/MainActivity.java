package com.example.kjjh.theresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ResultText;
    Button ButtonMin;
    Button ButtonAvg;

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
                MyMinimum myMinimum = new MyMinimum();

                ResultText.setText("The Results : " + (int)myMinimum.getResult());
            }
        });

        // Button2(Average)를 눌렀을 때
        ButtonAvg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                MyAverage myAverage = new MyAverage();

                double avgnum = myAverage.getResult();

                // 소수점을 자르기 위한 코드 부분
                java.text.DecimalFormat format = new java.text.DecimalFormat();
                format.applyLocalizedPattern("0.##");        // 소수점 두 자리만

                ResultText.setText("The Results : " + format.format(avgnum));
            }
        });
    }

    // 추상 클래스 사용
    public abstract class MyValues {
        int[] arr = {14, 5, 9, 3, 22, 12};

        public abstract double getResult();
    }

    // MyValues를 상속받는 자식 클래스에서 getResult 정의!
    public class MyMinimum extends MyValues {
        public double getResult() {
            int min = arr[0];   // 가장 작은 수를 저장할 변수

            // Find Minimum Number
            for(int i=0; i<arr.length; i++)
                if (arr[i] < min)
                    min = arr[i];
            return min;
        }
    }

    public class MyAverage extends MyValues {
        public double getResult() {
            double avg = 0.0;

            for(int i=0; i<arr.length; i++)
                avg += arr[i];
            avg /= arr.length;      // avg = arrSum / arrLength

            return avg;
        }
    }
}
