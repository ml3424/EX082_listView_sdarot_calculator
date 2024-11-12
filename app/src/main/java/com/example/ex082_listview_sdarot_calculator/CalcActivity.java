package com.example.ex082_listview_sdarot_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalcActivity extends AppCompatActivity {

    TextView tVa1, tVdq2, tVn, tVSn2, tVdOrq;
    ListView listV;
    Button back_btn;

    Intent g_intent;

    double[] arr_items_sidra = new double[20];
    double dorq_input, a1_input, an, n;
    boolean isHashbonit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        tVa1 = findViewById(R.id.tVa1);
        tVdq2 = findViewById(R.id.tVdq2);
        tVn = findViewById(R.id.tVn);
        tVSn2 = findViewById(R.id.tVSn2);
        tVdOrq = findViewById(R.id.tVdOrq);

        listV = findViewById(R.id.listV);
        back_btn = findViewById(R.id.back_btn);

        g_intent = getIntent();

        a1_input = g_intent.getDoubleExtra("a1_input", 0.0);
        dorq_input = g_intent.getDoubleExtra("dorq_input", 0.0);
        isHashbonit = g_intent.getBooleanExtra("isHashbonit", true);

        tVa1.setText(a1_input + "");
        tVdq2.setText(dorq_input + "");

        if(isHashbonit)
        {
            tVdOrq.setText("d =");
        }
        else //handasit
        {
            tVdOrq.setText("d =");
        }

    }
}