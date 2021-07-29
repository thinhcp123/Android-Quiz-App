package com.example.prm391x_quizapp_thinhtdfx08117;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {
    EditText editTextB2, editTextD4, editTextG6, editTextI8, editTextL10;
    ArrayList<RadioButton> btnRadioA1, btnRadioE5, btnRadioK9;
    ArrayList<CheckBox> checkBoxC3, checkBoxH7;
    Button btnSubmit;
    TextView tvGetName, tvCountTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Mapper();

        Intent inter = getIntent();
        String name = inter.getStringExtra("data");
        tvGetName.setText(name);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = getResult();
                if (result < 10) {
                    Toast.makeText(getApplicationContext(), "Hãy cố gắng hơn điểm của bạn là: " + result + " trên 10", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Hoàn hảo ! Điểm của bạn là: 10 trên 10", Toast.LENGTH_LONG).show();
                }
            }
        });
        //Đặt thời gian là 60s
        CountDownTimer countDownTimer = new CountDownTimer(62000, 1000) {
            int s = 60;

            @Override
            public void onTick(long millisUntilFinished) {
                //Cập nhật đồng hồ
                String time = "(" + s + "s)";
                tvCountTime.setText(time);
                s--;
            }
            //hết giờ, tính điểm và kết thúc phiên làm bài.
            @Override
            public void onFinish() {
                int result = getResult();
                Toast.makeText(getApplicationContext(), "Hết giờ điểm của bạn là: " + result + " trên 10", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
                startActivity(intent);

            }
        }.start();
    }

    private int getResult() {
        int result = 0;

        //Câu hỏi 1
        for (RadioButton rg : btnRadioA1) {
            if (rg.isChecked() && rg.getText().toString().contentEquals(getString(R.string.kq1))) {
                result++;
                break;
            }
        }

        //Câu hỏi 2
        String b2 = editTextB2.getText().toString();
        if (b2.contentEquals(getString(R.string.kq2))) {
            result++;
        }

        //Câu hỏi 3
        ArrayList<String> answer3 = new ArrayList<>();
        for (CheckBox cb : checkBoxC3) {
            if (cb.isChecked()) {
                answer3.add(cb.getText().toString());
            }
        }
        String resultC3 = TextUtils.join(", ", answer3);
        if (resultC3.contentEquals(getString(R.string.kq3))) {
            result++;
        }

        //Câu hỏi 4
        String d4 = editTextD4.getText().toString();
        if (d4.contentEquals(getString(R.string.kq4))) {
            result++;
        }

        //Câu hỏi 5
        for (RadioButton rg : btnRadioE5) {
            if (rg.isChecked() && rg.getText().toString().contentEquals(getString(R.string.kq5))) {
                result++;
                break;
            }
        }

        //Câu hỏi 6
        String g6 = editTextG6.getText().toString();
        String[] edg6 = getString(R.string.kq6).split(", ");
        for (String s : edg6) {
            if (s.contentEquals(g6)) {
                result++;
                break;
            }
        }

        //Câu hỏi 7
        ArrayList<String> answer7 = new ArrayList<>();
        for (CheckBox cb : checkBoxH7) {
            if (cb.isChecked()) {
                answer7.add(cb.getText().toString());
            }
        }
        String resultH7 = TextUtils.join(", ", answer7);
        if (resultH7.contentEquals(getString(R.string.kq7))) {
            result++;
        }

        //Câu hỏi 8
        String a8 = editTextI8.getText().toString();
        if (a8.contentEquals(getString(R.string.kq8))) {
            result++;
        }

        //Câu hỏi 9
        for (RadioButton r : btnRadioK9) {
            if (r.isChecked() && r.getText().toString().contentEquals(getString(R.string.kq9))) {
                result++;
                break;
            }
        }

        //Câu hỏi 10
        String a10 = editTextL10.getText().toString();
        if (a10.contentEquals(getString(R.string.kq10))) {
            result++;
        }

        return result;
    }


    private void Mapper() {
        //Các EditText cho câu 2,4,6,8,10
        editTextB2 = (EditText) findViewById(R.id.b2);
        editTextD4 = (EditText) findViewById(R.id.d4);
        editTextG6 = (EditText) findViewById(R.id.g6);
        editTextI8 = (EditText) findViewById(R.id.i8);
        editTextL10 = (EditText) findViewById(R.id.l10);


        // Radio cho câu 1
        btnRadioA1 = new ArrayList<RadioButton>();
        btnRadioA1.add((RadioButton) findViewById(R.id.a1_1));
        btnRadioA1.add((RadioButton) findViewById(R.id.a1_2));
        btnRadioA1.add((RadioButton) findViewById(R.id.a1_3));

        //Radio cho câu 5
        btnRadioE5 = new ArrayList<RadioButton>();
        btnRadioA1.add((RadioButton) findViewById(R.id.e5_1));
        btnRadioA1.add((RadioButton) findViewById(R.id.e5_2));
        btnRadioA1.add((RadioButton) findViewById(R.id.e5_3));

        //Radio cho câu 9
        btnRadioK9 = new ArrayList<RadioButton>();
        btnRadioK9.add((RadioButton) findViewById(R.id.k9_1));
        btnRadioK9.add((RadioButton) findViewById(R.id.k9_2));


        //CheckBox cho câu 5
        checkBoxC3 = new ArrayList<CheckBox>();
        checkBoxC3.add((CheckBox) findViewById(R.id.c3_1));
        checkBoxC3.add((CheckBox) findViewById(R.id.c3_2));
        checkBoxC3.add((CheckBox) findViewById(R.id.c3_3));
        checkBoxC3.add((CheckBox) findViewById(R.id.c3_4));

        //CheckBox cho câu 7
        checkBoxH7 = new ArrayList<CheckBox>();
        checkBoxH7.add((CheckBox) findViewById(R.id.h7_1));
        checkBoxH7.add((CheckBox) findViewById(R.id.h7_2));
        checkBoxH7.add((CheckBox) findViewById(R.id.h7_3));
        checkBoxH7.add((CheckBox) findViewById(R.id.h7_4));


        //Button Gửi kết quả
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //Thời gian và tên người dùng
        tvGetName = (TextView) findViewById(R.id.tvGetName);
        tvCountTime = (TextView) findViewById(R.id.tvCountTime);

    }
}