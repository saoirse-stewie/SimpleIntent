package com.example.SimpleIntent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MyActivity2 extends Activity implements OnClickListener{
    EditText data;
    EditText data2;
    EditText data3;
    Button  btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        data = (EditText) findViewById(R.id.etDataReceived);
        data2 = (EditText) findViewById(R.id.etDataReceived2);
        data3 = (EditText) findViewById(R.id.etDataReceived3);

        btnDone = (Button) findViewById(R.id.btn3);
        btnDone.setOnClickListener(this);

        Intent i = getIntent();


        Bundle myBundle =  i.getExtras();
        Double v1 = myBundle.getDouble("val1");
        Double v2 = myBundle.getDouble("val2");
        Double v3 = myBundle.getDouble("val3");
        Double v4 = myBundle.getDouble("val4");
        Double v5 = myBundle.getDouble("val5");

        double max;
        double min;

        if(v1>v2&&v1>v3&&v1>v4&&v1>v5) {
            max = v1;
            data2.setText("max is: number1 : " + max);
        }
       else if(v2>v1&&v2>v3&&v2>v4&&v2>v5) {
            max = v2;
            data2.setText("max is: number2 : " + max);
        }
        else if(v3>v2&&v3>v1&&v3>v4&&v3>v5) {
            max = v3;
            data2.setText("max is: number3 : " + max);
        }
        else if(v4>v2&&v4>v3&&v4>v1&&v4>v5) {
            max = v4;
            data2.setText("max is: number4 : " + max);
        }
         else if(v5>v2&&v5>v3&&v5>v4&&v5>v1) {
            max = v5;
            data2.setText("max is: number5 : " + max);
        }

       if(v1<v2&&v1<v3&&v1<v4&&v1<v5) {
            min = v1;
            data3.setText("min is: number1 : " + min);
        }
        else if(v2<v1&&v2<v3&&v2<v4&&v2<v5) {
            min = v2;
            data3.setText("min is: number1 : " + min);
        }
        if(v3<v2&&v3<v1&&v3<v4&&v3<v5) {
            min = v3;
            data3.setText("min is: number1 : " + min);
        }
        if(v4<v2&&v4<v3&&v4<v1&&v4<v5) {
            min = v4;
            data3.setText("min is: number1 : " + min);
        }
        if(v5<v2&&v5<v3&&v5<v4&&v5<v1) {
            min = v5;
            data3.setText("min is: number1 : " + min);
        }

        Double Result =  v1 + v2 + v3+ v4+ v5;

        data.setText("data = " + "\nv1 =" + v1 + "\nv2 = " + v2 + "\nv3 = " + v3 + " \nv4 = " + v4 + "\nv5= " + v5 +
                "\nresult=" + Result);


        myBundle.putDouble("vresult", Result);



        i.putExtras(myBundle);


        setResult(Activity.RESULT_OK, i);


    }//onCreate

    @Override
    public void onClick(View v) {
        finish();
    }

}
