package com.DataFlair.mycalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.pm.PackageManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity5 extends AppCompatActivity {

    public static String art[] = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
    public static String pri[] = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
    TextView tt;
  ArrayList<String> trans;
  ArrayList<String> transart;

    //    public static final String key = "com.DataFlair.mycalculator.key";
    public static int y = 0;
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        tt = findViewById(R.id.textView9);
        ed = findViewById(R.id.editTextNumber);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);

        trans = new ArrayList<String>();
        transart = new ArrayList<String>();
//        if(y!=0)
//        {
//            Collections.copy(trans,getArrayList("please"));
            trans = getArrayList("please");
            transart = getArrayList("welcome");
//        }

    }


    public void start(View view) {
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.initiateScan();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//            SharedPreferences sharedPreferenc = getSharedPreferences("demo", MODE_PRIVATE);
//            y = sharedPreferenc.getInt("y", 6);


        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                tt.setText("cancelled");
            } else {

                y++;
                art[y] = intentResult.getContents();
                pri[y] = ed.getText().toString();

//                tt.setText(trans.get(y-1));


//
            }
        }

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



    public void saveArrayList(ArrayList<String> trans, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(trans);
        editor.putString(key, json);

        editor.apply();
    }



        public void confirma (View view)
        {

//            SharedPreferences sharedPreferences = getSharedPreferences("demo", MODE_PRIVATE);
//            SharedPreferences.Editor edit = sharedPreferences.edit();
//                    edit.putString("0", pri[1]);
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < art.length; i++) {
//                sb.append(art[i]).append(",");
//            }
//            edit.putString("play", sb.toString());
//                    edit.putInt("y",y);
//            edit.apply();
//             trans.add("30");
//             trans.add("70");
            transart.add(art[y]);
            trans.add(pri[y]);
              saveArrayList(trans,"please");
              saveArrayList(transart,"welcome");

//
            Intent intent = new Intent(this, MainActivity.class);


            startActivity(intent);
        }

    }


