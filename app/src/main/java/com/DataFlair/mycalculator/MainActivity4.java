package com.DataFlair.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        TextView t1 = findViewById(R.id.textView5);
        TextView t2 = findViewById(R.id.textView7);

        Intent intent = getIntent();
        Bundle c = this.getIntent().getExtras();
        double mrp = c.getDouble(MainActivity3.exrp);
        float t = c.getFloat(MainActivity3.ex);
        double prof = (t-(mrp/2));
        double dis = ((mrp-t)/mrp)*100;
        if(dis<32)
        {
            t1.setText("SUPER SIX");
            t1.setBackgroundColor(Color.parseColor("#FF0BE413"));
        }
        else if((dis>32)&&(dis<35))
        {

            t1.setText(("BOUNDARY"));
            t1.setBackgroundColor(Color.parseColor("#FF5E9160"));
        }
        else if ((dis>35)&&(dis<40))
        {
            t1.setText("SINGLE");
            t1.setBackgroundColor(Color.parseColor("#FF8F3B3B"));
        }
        else
        {
            t1.setText("BOLD");
            t1.setBackgroundColor(Color.parseColor("#FFE80C0C"));
        }
        t2.setText("PROFIT : " + prof);







    }
}