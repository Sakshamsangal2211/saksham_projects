package com.DataFlair.mycalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class MainActivity extends AppCompatActivity {
        TextView textView, tv;
        Button bt;
        int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int x = 0;
        int i;
        int j;
        int v;
        ArrayList<String> receiv;
        ArrayList<String> wlc;

//        public static String arti[] = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
//        public static String pric[] = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        public static final String ok = "com.DataFlair.mycalculator.ok";
        public static final String ok1 = "com.DataFlair.mycalculator.ok1";
        public static final String ok2 = "com.DataFlair.mycalculator.ok2";
        public static final String ok3 = "com.DataFlair.mycalculator.ok3";
        public static final String ok4 = "com.DataFlair.mycalculator.ok4";
        public static final String ok5 = "com.DataFlair.mycalculator.ok5";
        public static final String ok6 = "com.DataFlair.mycalculator.ok6";
        public static final String ok7 = "com.DataFlair.mycalculator.ok7";
        public static final String ok8 = "com.DataFlair.mycalculator.ok8";
        public static final String ok9 = "com.DataFlair.mycalculator.ok9";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            bt = findViewById(R.id.button3);





            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);


        }



        public void scanButton(View view) {
            IntentIntegrator intentIntegrator = new IntentIntegrator(this);
            intentIntegrator.initiateScan();
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            textView = findViewById(R.id.textView6);
            receiv = new ArrayList();
            wlc = new ArrayList();
            wlc = getArrayList("welcome");

            receiv = getArrayList("please");
//            SharedPreferences sharedPreferences = getSharedPreferences("demo", MODE_PRIVATE);
//            String m = sharedPreferences.getString("0","djg");

//            textView.setText(""+m);

            IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (intentResult != null) {
                if (intentResult.getContents() == null) {
                    textView.setText("cancelled");
                } else {
//                textView.setText(intentResult.getContents());
                    x++;

//                     v = Integer.parseInt(sharedPreferences.getString("bs", "dgdg"));

//                    if (intentResult.getContents().equals("950"))
//                        arr[x] = 500;
//                    else if (intentResult.getContents().equals("510045"))
//                        arr[x] = 1020;
//                    arr[x] = 1020;
//                    else if (intentResult.getContents() == "4121796")
//                        arr[x] = 1100;
//                    else if (intentResult.getContents() == "4121829")
//                        arr[x] = 1020;
                    for (j = 0; j < wlc.size(); j++) {
                        if (intentResult.getContents().equals(wlc.get(j)))
                        {
                            arr[x] = Integer.parseInt(receiv.get(j));
                        }
                        }
//
                }
            }
               textView.setText(""+arr[x]);






            super.onActivityResult(requestCode, resultCode, data);

        }
    public ArrayList<String> getArrayList(String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        return gson.fromJson(json, type);
    }


        public void okbutton(View view) {
            Intent intent = new Intent(this, MainActivity3.class);
            Bundle b = new Bundle();

            b.putInt(ok, x);
            b.putInt(ok1, arr[1]);
            b.putInt(ok2, arr[2]);
            b.putInt(ok3, arr[3]);
            b.putInt(ok4, arr[4]);
            b.putInt(ok5, arr[5]);
            b.putInt(ok6, arr[6]);
            b.putInt(ok7, arr[7]);
            b.putInt(ok8, arr[8]);
            b.putInt(ok9, arr[9]);
            intent.putExtras(b);
            startActivity(intent);
        }

        public void input(View view) {
            Intent intent = new Intent(this, MainActivity5.class);
            startActivity(intent);
        }
    }






















