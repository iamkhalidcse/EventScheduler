package com.example.khalidjavaid.bgsbu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ite);
        Toast.makeText(Ite.this,"ITTE", Toast.LENGTH_SHORT).show();


        final ListView  listViewIte = findViewById(R.id.IteListView );
        ArrayList arrayListIte = new ArrayList();

        arrayListIte.add("Mr. Malik Mubashir Hassan             Assistant Professor          mubasher2003@gmail.com");
        arrayListIte.add("Mr. Nikhil Gupta                      HOD                          nikhilgup1@gmail.com");
        arrayListIte.add("Mr. Rakesh Singh Sambyal              Assistant Professor          sambyal.rakesh7@gmail.com");
        arrayListIte.add("Mr. Manmeet Singh                     Assistant Professor          mannirulz@gmail.com");
        arrayListIte.add("Mr. Faisal Rasheed Lone               Assistant Professor    ");
        arrayListIte.add("Mr. Sajjad Ahmed                      Assistant Professor          sajjad435@gmail.com");
        arrayListIte.add("Mr. Dewan Imdadul Islam               Assistant Professor          dewanimdadulislam@gmail.com");
        arrayListIte.add("Mr. Susobhan Das                      Assistant Professor     ");
        arrayListIte.add("Mr. Pankaj Choudhary                  Assistant Professor          pschoudhary007@gmail.com");
        arrayListIte.add("Mr. Sunil Dalal                       Assistant Professor          sunildalal57@gmAIL.com");
        arrayListIte.add("Mr. Vishal Sharma                     Assistant Professor          vishal.2812@gmail.com");
        arrayListIte.add("Mr.  Rashid Shawl                     Assistant Professor          rasheed143@gmail.com");



        ArrayAdapter adapter = new ArrayAdapter(Ite.this, android.R.layout.simple_list_item_1,arrayListIte);
        //Map the listview to adapter
        listViewIte.setAdapter(adapter);
























    }
}
