package com.llorca.llorca_aries_labexercise3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        FileInputStream fin = null;
        try {
            fin = openFileInput("data1.txt");
            int token;
            String temp = "";
            while((token = fin.read()) != -1 ){
                temp = temp + ((char) token);
            }
            fin.close();
            try{
                String[] list = temp.split("_");
                ((TextView) (findViewById(R.id.multiAutoCompleteTextView))).setText(list[0]);
            } catch (Exception e){
                Log.d("error", "empty strings");
            }

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void previous (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
