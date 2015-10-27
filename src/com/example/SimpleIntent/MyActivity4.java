package com.example.SimpleIntent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MyActivity4 extends Activity  {
    EditText data;
    EditText data2;
    EditText data3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main4);

        data = (EditText) findViewById(R.id.e);
        data2 = (EditText) findViewById(R.id.e2);
        data3 = (EditText) findViewById(R.id.e3);

        double max;
        double min;

        Uri uri = getIntent().getData();

        String num1 = uri.getQueryParameter("num1");
        String num2 = uri.getQueryParameter("num2");
        String num3 = uri.getQueryParameter("num3");
        String num4 = uri.getQueryParameter("num4");
        String num5 = uri.getQueryParameter("num5");

        Double number = Double.parseDouble(num1);
        Double number2 = Double.parseDouble(num2);
        Double number3 = Double.parseDouble(num3);
        Double number4 = Double.parseDouble(num4);
        Double number5 = Double.parseDouble(num5);

        Double result = number + number2 + number3 + number4 + number5;

        if(number>number2&&number>number3&&number>number4&&number>number5) {
            max = number;
            data2.setText("max is: number1 : " + max);
        }
        else if (number2>number&&number2>number3&&number2>number4&&number2>number5) {
            max = number2;
            data2.setText("max is: number2 : " + max);
        }
        else if (number3>number2&&number3>number&&number3>number4&&number3>number5) {
            max = number3;
            data2.setText("max is: number3 : " + max);
        }
        else if (number4>number&&number4>number2&&number4>number3&&number4>number5) {
            max = number4;
            data2.setText("max is: number4 : " + max);
        }
        else if (number5>number&&number5>number2&&number5>number3&&number5>number4) {
            max = number5;
            data2.setText("max is: number5 : " + max);
        }

        if (number<number2&&number<number3&&number<number4&&number<number5) {
            min = number;
            data3.setText("min is: number1 : " + min);
        }
        else if (number2<number&&number2<number3&&number2<number4&&number2<number5) {
            min = number2;
            data3.setText("min is: number1 : " + min);
        }
        else if (number3<number&&number3<number2&&number3<number4&&number3<number5) {
            min = number3;
            data3.setText("min is: number1 : " + min);
        }
        else if (number4<number2&&number4<number3&&number4<number&&number4<number5) {
            min = number4;
            data3.setText("min is: number1 : " + min);
        }
        else if (number5<number2&&number5<number3&&number5<number4&&number5<number) {
            min = number5;
            data3.setText("min is: number1 : " + min);
        }





        data.setText("data = " + "\nv1 =" + number + "\nv2 = " + number2 + "\nv3 = " + number3 + " \nv4 = " + number4 + "\nv5= " + number5 +
                "\nresult=" + result);




    }//onCreate


}


