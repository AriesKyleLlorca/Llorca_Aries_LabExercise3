package com.llorca.llorca_aries_labexercise3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etParagraph1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etParagraph1 = findViewById(R.id.editText);
    }
    public void saveOtherWord(View view) throws IOException{
        String paragraph1 = etParagraph1.getText().toString()+ "_";
        String FILENAME = "data1.txt";
        FileOutputStream fosWriter = null;
        fosWriter = openFileOutput(FILENAME, Context.MODE_PRIVATE);
        fosWriter.write(paragraph1.getBytes());
        fosWriter.close();
    }

    public void next(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}
