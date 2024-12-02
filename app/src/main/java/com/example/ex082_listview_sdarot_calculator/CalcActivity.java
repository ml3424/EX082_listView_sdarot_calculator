package com.example.ex082_listview_sdarot_calculator;

import static android.icu.util.MeasureUnit.Complexity.SINGLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalcActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView tVa1, tVdq2, tVn, tVSn2, tVdOrq;
    ListView listV;
    Button back_btn;

    Intent g_intent;

    Double[] arr_items_sidra = new Double[20];
    double dorq_input, a1_input, n, sum;;
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

        // set text in text views:
        tVa1.setText(a1_input + "");
        tVdq2.setText(dorq_input + "");

        if(isHashbonit)
        {
            tVdOrq.setText("d =");
            for(int i = 0; i < 20; i++)
            {
                arr_items_sidra[i] = a1_input + dorq_input*i;
            }
        }
        else //handasit
        {
            tVdOrq.setText("q =");
            for(int i = 0; i < 20; i++)
            {
                arr_items_sidra[i] = a1_input * Math.pow(dorq_input, i);
            }
        }


        // list view context:
        listV.setOnItemClickListener(this);
        listV.setChoiceMode (ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr_items_sidra);
        listV.setAdapter(adp);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        n = position + 1;
        tVn.setText((int)n + "");
        n = position + 1;  // add 1 because n should start at 1


        if (isHashbonit) {
            sum = (n / 2.0) * (2 * a1_input + (n - 1) * dorq_input);
        } else {
            sum = a1_input * (Math.pow(dorq_input, n) - 1) / (dorq_input - 1);
        }

        tVSn2.setText(String.format("%.2f", sum)); // two digits after .

    }

    public void back_to_main_activity(View view) {
        finish();

    }
}