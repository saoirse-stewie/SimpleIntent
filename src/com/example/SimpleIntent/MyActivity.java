package com.example.SimpleIntent;
// Multi-Activity Application
// Activity1: collects two data items from the user's UI, places
//			  them into a Bundle, and calls Activity2
// Activity2: accepts two data items, adds them, returns result

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    EditText txt1;
    EditText txt2;
    EditText txt3;
    EditText txt4;
    EditText txt5;
    EditText t6;
    EditText t7;
    EditText t8;
    EditText t9;
    EditText t10;

    TextView txtResult;
    Button   btnAdd;
    Button b2;
    Button b3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txt1 = (EditText) findViewById(R.id.EditText01);
        txt2 = (EditText) findViewById(R.id.EditText02);
        txt3 = (EditText) findViewById(R.id.EditText03);
        txt4 = (EditText) findViewById(R.id.EditText04);
        txt5 = (EditText) findViewById(R.id.EditText05);

        txtResult = (TextView) findViewById(R.id.txtResult);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);


        btnAdd.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Double v1 = Double.parseDouble(txt1.getText().toString());
                Double v2 = Double.parseDouble(txt2.getText().toString());
                Double v3 = Double.parseDouble(txt3.getText().toString());
                Double v4 = Double.parseDouble(txt4.getText().toString());
                Double v5 = Double.parseDouble(txt5.getText().toString());

                Intent ia2 = new Intent(MyActivity.this, MyActivity2.class);

                Bundle b = new Bundle();

                b.putDouble("val1", v1);
                b.putDouble("val2", v2);
                b.putDouble("val3", v3);
                b.putDouble("val4", v4);
                b.putDouble("val5", v5);

                ia2.putExtras(b);

                startActivityForResult(ia2, 101);
            }

        });
        b2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Double v1 = Double.parseDouble(txt1.getText().toString());
                Double v2 = Double.parseDouble(txt2.getText().toString());
                Double v3 = Double.parseDouble(txt3.getText().toString());
                Double v4 = Double.parseDouble(txt4.getText().toString());
                Double v5 = Double.parseDouble(txt5.getText().toString());


                Intent ia = new Intent(MyActivity.this, MyActivity3.class);

                Bundle b2 = new Bundle();


                double[] array = {v1,v2,v3,v4,v5};

                b2.putDoubleArray("array", array);

               // b2.putDouble("val1", v1);
              //  b2.putDouble("val2", v2);
                //b2.putDouble("val3", v3);
               // b2.putDouble("val4", v4);
               // b2.putDouble("val5", v5);

                ia.putExtras(b2);

                startActivityForResult(ia, 101);
            }
        });

        b3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Editable e = txt1.getText();
                String num1 = String.format("num1=%s",e);
                Editable e2 = txt2.getText();
                String num2 = String.format("num2=%s",e2);
                Editable e3 = txt3.getText();
                String num3 = String.format("num3=%s",e3);
                Editable e4 = txt4.getText();
                String num4 = String.format("num4=%s",e4);
                Editable e5 = txt5.getText();
                String num5 = String.format("num5=%s",e5);

                String base = "add://example.com/sum";

                String address = String.format("%s?%s&%s&%s&%s&%s",base,num1,num2,num3,num4,num5);

                Uri uri = Uri.parse(address);

                Intent  ii = new Intent(Intent.ACTION_VIEW,uri);

                startActivity(ii);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try	{
            if ((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
                Bundle myResultBundle = data.getExtras();
                Double myResult = myResultBundle.getDouble("vresult");
                txtResult.setText("Sum is " + myResult);
            }
        }
        catch (Exception e) {
            txtResult.setText("Problems - " + requestCode + " " + resultCode);
        }
    }//onActivityResult

}//Activity1