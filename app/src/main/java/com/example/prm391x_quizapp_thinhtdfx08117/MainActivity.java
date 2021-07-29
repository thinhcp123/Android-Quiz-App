package com.example.prm391x_quizapp_thinhtdfx08117;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etFullName;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFullName = (EditText) findViewById(R.id.etFullName);
        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = etFullName.getText().toString();
                if (fullName.trim().length() < 4) {
                    Toast.makeText(getApplicationContext(), "Nhập tên có hơn 4 chữ", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                    intent.putExtra("data", fullName);
                    startActivity(intent);
                }
            }
        });
    }
}