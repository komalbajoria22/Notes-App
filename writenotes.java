package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class writenotes extends AppCompatActivity {
    EditText editnote;
    int noteID;
    Button save;

    public void savenote(View view){
        
        Intent intent=getIntent();
        noteID = intent.getIntExtra("noteID",-1);

        if(noteID != -1){
            editnote.setText(MainActivity.arrayList.get(noteID));
        }
        else{
            MainActivity.arrayList.add("");
            noteID = MainActivity.arrayList.size() - 1;
            MainActivity.arrayAdapter.notifyDataSetChanged();
        }

        editnote.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                MainActivity.arrayList.set(noteID,String.valueOf(s));
                MainActivity.arrayAdapter.notifyDataSetChanged();

                //To store data permanently
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
                HashSet<String> hashSet=new HashSet(MainActivity.arrayList);
                sharedPreferences.edit().putStringSet("arrayList",hashSet).apply();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writenotes);

        editnote= (EditText)findViewById(R.id.editnote);
         save = (Button) findViewById(R.id.save);

    }
}