package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static android.system.Os.remove;


public class MainActivity extends AppCompatActivity {

    ListView listview;
    static ArrayList<String> arrayList= new ArrayList<String>();
  static ArrayAdapter arrayAdapter;


  //creating option of ADD NOTE in menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);

        if(item.getItemId() == R.id.add_notes)
        {
            Intent intent = new Intent(getApplicationContext(), writenotes.class);
            startActivity(intent);
return true;
        }

        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    listview=(ListView)findViewById(R.id.listview);

        arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listview.setAdapter(arrayAdapter);


        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
        HashSet<String> hashSet=(HashSet<String>)sharedPreferences.getStringSet("arrayList",null);

        if(hashSet==null){
            arrayList.add("Example note");
        }
        else{
            arrayList=new ArrayList<>(hashSet);
        }


      //editing existing note
      listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Intent intent= new Intent(getApplicationContext(),writenotes.class);
              intent.putExtra("noteID",position);
              startActivity(intent);
          }
      });

        // appearing alert dialog box for deleting a note
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,final int position, long id) {



                new AlertDialog.Builder(MainActivity.this)

                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete it?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.remove(position);
                                arrayAdapter.notifyDataSetChanged();

                                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("com.example.notes",Context.MODE_PRIVATE);
                                HashSet<String> hashSet= new HashSet(MainActivity.arrayList);
                                sharedPreferences.edit().putStringSet("arrayList",hashSet).apply();
                            }
                        })
                        .setNegativeButton("Cancel",null)
                        .show();

                return false;
            }
        });




    }


}
