package com.komal.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button add,sub,multi,div;
    Button one,two,three,four,five,six,seven,eight,nine,zero,doublezero,dot,clear,equals;
    EditText textView;

    float value1,value2;

    boolean addbtn,subbtn,multibtn,divbtn;
    boolean click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (EditText) findViewById(R.id.textview);



        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        doublezero = (Button) findViewById(R.id.doublezero);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        multi = (Button) findViewById(R.id.multi);
        div = (Button) findViewById(R.id.div);
        clear = (Button) findViewById(R.id.clear);
        equals = (Button) findViewById(R.id.equals);
        dot = (Button) findViewById(R.id.dot);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText(textView.getText() + "1");

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText(textView.getText() + "3");

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "4");
            }
        });


        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText(textView.getText() + "5");

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText(textView.getText() + "7");

            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText(textView.getText() + "9");

            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "0");
            }
        });

        doublezero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText(textView.getText() + "00");

            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + ".");
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click=true;
                if (textView == null) {
                    textView.setText("");
                } else {
                    float value1=Float.parseFloat(textView.getText()+"");
                    addbtn = true;
                    textView.setText(null);

                }
            }
        });


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float value1=Float.parseFloat(textView.getText()+"");
                subbtn = true;
                textView.setText(null);

            }
        });


        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float value1=Float.parseFloat(textView.getText()+"");
                divbtn = true;
                textView.setText(null);

            }
        });


        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             value1=Float.parseFloat(textView.getText()+"");
                multibtn=true;
                textView.setText(null);

            }
        });



        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               value2=Float.parseFloat(textView.getText()+"");

                  if(addbtn==true){
                      textView.setText(String.valueOf(value1+value2));
                      addbtn=false;
                  }

                if(subbtn==true){
                    textView.setText(String.valueOf(value1-value2));
                 subbtn=false;
                }

                if(divbtn==true){
                    textView.setText(String.valueOf(value1/value2));
                       divbtn=false;
                }

                if(multibtn==true){
                    textView.setText(String.valueOf(value1*value2));
                    multibtn=false;
                }


            }
        });



    }
}