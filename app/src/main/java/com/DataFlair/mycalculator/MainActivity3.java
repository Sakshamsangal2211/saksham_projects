package com.DataFlair.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    public static final String exrp = "com.DataFlair.mycalculator.exrp";
    public static final String ex = "com.DataFlair.mycalculator.ex";
    EditText  num;

    double mrp,tot;
    float t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        num = findViewById(R.id.editTextNumber2);
        Button butt = findViewById(R.id.button2);


//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textView3);
        TextView textView1 = findViewById(R.id.textView4);

        Intent intent = getIntent();
        Bundle b = this.getIntent().getExtras();
        int numb = b.getInt(MainActivity.ok);
        int mrp1 = b.getInt(MainActivity.ok1);
        int mrp2 = b.getInt(MainActivity.ok2);
        int mrp3 = b.getInt(MainActivity.ok3);
        int mrp4 = b.getInt(MainActivity.ok4);
        int mrp5 = b.getInt(MainActivity.ok5);
        int mrp6= b.getInt(MainActivity.ok6);
        int mrp7 = b.getInt(MainActivity.ok7);
        int mrp8 = b.getInt(MainActivity.ok8);
        int mrp9 = b.getInt(MainActivity.ok9);

        mrp = (mrp1+mrp2+mrp3+mrp4+mrp5+mrp6+mrp7+mrp8+mrp9);
        tot = (75*mrp)/100;
//        textView.setText(message);
//        int mrp = intent.getIntExtra(MainActivity.mrp);
//        Bundle b = this.getIntent().getExtras();
//        mrp1 = b.getDouble(MainActivity.mrp);
//        double tot = b.getDouble(MainActivity.tot1);
        textView.setText("DISCOUNTED AMOUNT : " + tot);
        textView1.setText("MRP TOTAL : " + mrp);

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = num.getText().toString();
                t = Float.parseFloat(str);
            }

        });


    }

    public void sendmrp(View view) {
        Intent intent = new Intent(this, MainActivity4.class);
        Bundle c = new Bundle();
        double trp = mrp;
        float tx = t;
        c.putFloat(ex,tx);
        c.putDouble(exrp, trp);
        intent.putExtras(c);
        startActivity(intent);
    }
}
