package com.example.dell.mathematicalsolution;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    Spinner Spinn_Chapter;
    List<String> List_Chapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinn_Chapter = (Spinner) findViewById(R.id.spinner1);
        List_Chapter = new ArrayList<String>();

        List_Chapter.add("Select One");
        List_Chapter.add("Factorisation");
        List_Chapter.add("Differentiation");
        List_Chapter.add("Integration");
        List_Chapter.add("Linear Equation");

        ArrayAdapter<String> adp = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, List_Chapter);

        Spinn_Chapter.setAdapter(adp);
        Spinn_Chapter.setSelection(0);

        Spinn_Chapter.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub

                switch (arg2) {

                    case 1:
                        Intent i = new Intent(MainActivity.this, Factorisation.class);
                        startActivity(i);
                        break;
                    case 2:
                        Intent j = new Intent(MainActivity.this, Differentiation.class);
                        startActivity(j);
                        break;
                    case 3:
                        Intent k = new Intent(MainActivity.this, Integration.class);
                        startActivity(k);
                        break;
                    case 4:
                        Intent l = new Intent(MainActivity.this, Linear.class);
                        startActivity(l);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }
}