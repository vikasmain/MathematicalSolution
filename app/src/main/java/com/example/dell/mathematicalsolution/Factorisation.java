package com.example.dell.mathematicalsolution;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Factorisation extends Activity {

    TextView Text_Eqn, Text_X1, Text_X2;
    String Str_Eqn, Str_X1, Str_X2;
    Button Butt_Get;
    EditText Edit_X2, Edit_X1, Edit_X0;

    double a, b, c;
    double x1, x2;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factorization);

        Text_Eqn = (TextView) findViewById(R.id.textView2);
        Edit_X2 = (EditText) findViewById(R.id.editText1);
        Edit_X1 = (EditText) findViewById(R.id.editText2);
        Edit_X0 = (EditText) findViewById(R.id.editText3);
        Butt_Get = (Button) findViewById(R.id.button1);
        Text_X1 = (TextView) findViewById(R.id.textView3);
        Text_X2 = (TextView) findViewById(R.id.textView4);

        Edit_X2.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL
                | InputType.TYPE_NUMBER_FLAG_SIGNED);
        Edit_X1.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL
                | InputType.TYPE_NUMBER_FLAG_SIGNED);
        Edit_X0.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL
                | InputType.TYPE_NUMBER_FLAG_SIGNED);

        Str_Eqn = "Consider our equation is like below<br/><br/>" +
                "<font color = '#FF0000'> ax^2 + bx^1 + cx^0 = 0</font>";
        Text_Eqn.setText(Html.fromHtml(Str_Eqn));

        Butt_Get.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                try {
                    count = 0;

                    if(Edit_X2.getText().toString().equalsIgnoreCase(""));
                    else
                        count ++;

                    if(Edit_X1.getText().toString().equalsIgnoreCase(""));
                    else
                        count ++;

                    if(Edit_X0.getText().toString().equalsIgnoreCase(""));
                    else
                        count ++;

                    if (count == 3)
                        fact();

                    else
                        error();
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Enter The Values Correctly",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void fact() {

        a = Double.parseDouble(Edit_X2.getText().toString());
        b = Double.parseDouble(Edit_X1.getText().toString());
        c = Double.parseDouble(Edit_X0.getText().toString());

        x1 = (-b + (Math.sqrt( (b*b) - (4*a*c)))) / (2*a);
        x2 = (-b - (Math.sqrt( (b*b) - (4*a*c)))) / (2*a);

        Str_X1 = "x1 : <font color = '#FF0000'>" + x1 + "</font>";
        Str_X2 = "x2 : <font color = '#FF0000'>" + x2 + "</font>";

        Text_X1.setText(Html.fromHtml(Str_X1));
        Text_X2.setText(Html.fromHtml(Str_X2));
    }

    public void error() {

        Text_X1.setText("Can't find x1");
        Text_X2.setText("Can't find x2");
    }
}
