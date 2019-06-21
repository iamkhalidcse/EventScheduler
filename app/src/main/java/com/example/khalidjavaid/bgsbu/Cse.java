package com.example.khalidjavaid.bgsbu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse);
        Toast.makeText(Cse.this,"CSE", Toast.LENGTH_SHORT).show();


        final ListView listViewCse = findViewById(R.id.CseListView);
        ArrayList arrayListCse = new ArrayList();
        arrayListCse.add("Mr.Khalil Ahmed        HOD                                     amitdogra004@gmail.com");
        arrayListCse.add("Mr. Amit Dogra         Assistant professor                     amitdogra004@gmail.com");
        arrayListCse.add("Mr. Rafeeq Ahmed       Assistant professor                     rafeeq.amu@gmail.com");
        arrayListCse.add("Mr. Aditya Gupta       Assistant professor                     adityagupta.smvdu@gmail.com");
        arrayListCse.add("Mr. Sparsh Sharma      Assistant professor                     sparshsharma@outlook.com");
        arrayListCse.add("Mr. Prabal Verma       Assistant professor                     prabalverma357@gmail.com");
        arrayListCse.add("Mr. Mrityunjay Singh   Assistant professor                     mriyunjay.cse045@gmail.com");
        arrayListCse.add("Mrs. Rukhsana Thaker   Lecturer                               rukhs153@gmail.com");
        arrayListCse.add("Ms. Yusera Farooq      AP(contractual)                        yusrakhan.205@gmail.com");
        arrayListCse.add("Mr. Taseem Nazir       AP(Contractual)                        taseem.mufti@yahoo.com");
        arrayListCse.add("Mr. Mohd Saleem        AP(Contractual)                        mohdsaleem099@gmail.com");

        ArrayAdapter adapter = new ArrayAdapter(Cse.this, android.R.layout.simple_list_item_1,arrayListCse);

        //Map the listView to adapter
        listViewCse.setAdapter(adapter);




    }
}
