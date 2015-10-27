package com.example.SimpleIntent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MyActivity3 extends Activity implements OnClickListener{
    EditText data;
    EditText data2;
    EditText data3;
    Button  btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);

        data = (EditText) findViewById(R.id.etDataReceived6);
        data2 = (EditText) findViewById(R.id.EditText05);
        data3 = (EditText) findViewById(R.id.EditText06);

        btnDone = (Button) findViewById(R.id.btn5);
        btnDone.setOnClickListener(this);
        double max;
        double min;

        Intent i = getIntent();

        Bundle myBundle =  i.getExtras();


        double[] array = myBundle.getDoubleArray("array");



        if (array[0] > array[1] && array[0]> array[2] &&array[0]>array[3] && array[0] > array[4])
        {
            max = array[0];
            data2.setText("max = 1"+ max);

        }
        else if (array[1] > array[0] && array[1]> array[2] &&array[1]>array[3] && array[1] > array[4])
        {
            max = array[1];
            data2.setText("max = 1"+ max);

        }
        else if (array[2] > array[1] && array[2]> array[0] &&array[2]>array[3] && array[2] > array[4])
        {

            max = array[2];
            data2.setText("max = 1"+ max);
        }
        else if (array[3] > array[1] && array[3]> array[2] &&array[3]>array[0] && array[3] > array[4])
        {
            max = array[3];
            data2.setText("max = 1"+ max);
        }
        else if (array[4] > array[1] && array[4]> array[2] &&array[4]>array[3] && array[4] > array[0])
        {
            max = array[4];
            data2.setText("max = 1"+ max);
        }


        if (array[0] < array[1] && array[0]< array[2] &&array[0]<array[3] && array[0] < array[4])
        {
            min = array[0];
            data3.setText("min = 1"+ min);
        }
        else if (array[1] < array[0] && array[1]< array[2] &&array[1]<array[3] && array[1] < array[4])
        {
            min = array[1];
            data3.setText("min = 1"+ min);
        }
        else if (array[2] < array[1] && array[2]< array[0] &&array[2]<array[3] && array[2] < array[4])
        {
            min= array[2];
            data3.setText("min = 1"+ min);
        }
        else if (array[3] < array[1] && array[3]< array[2] &&array[3]<array[4] && array[3] < array[0])
        {
            min = array[3];
            data3.setText("min = 1"+ min);
        }
       else if (array[4] < array[1] && array[4]< array[2] &&array[4]<array[3] && array[4] < array[0])
        {
           min = array[4];
            data3.setText("min = 1"+ min);
        }


        double result = array[0] +array[1] + array[2] + array[3] + array[4];

        data.setText("Sum is " +result);


        myBundle.putDouble("vresult", result);


        i.putExtras(myBundle);


        setResult(Activity.RESULT_OK, i);


    }//onCreate

    @Override
    public void onClick(View v) {
        // close current screen - terminate Activity2
        finish();
    }

}
