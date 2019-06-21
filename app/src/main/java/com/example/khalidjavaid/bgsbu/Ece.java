package com.example.khalidjavaid.bgsbu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ece extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece);



        Toast.makeText(Ece.this,"ECE", Toast.LENGTH_SHORT).show();

        final ListView listViewEce = findViewById(R.id.EceListView);
        ArrayList arrayListEce = new ArrayList();


        arrayListEce.add("Mr. Vishal Puri               HOD                                     parmandal@gmail.com");
        arrayListEce.add("Mr. Mehmood-ul-Hassan         Assistant Professor      ");
        arrayListEce.add("Mr. Haider Mehraaj            Assistant Professor                     haidermehraj@coetbgsbu.org");
        arrayListEce.add("Mr.Junaid Farooq War          Assistant Professor                     warjunaid@coetbgsbu.org");
        arrayListEce.add("Mr. Arshid Ahmed              Assistant Professor                     bhat.nitsri@coetbgsbu.org");
        arrayListEce.add("Mr. Mohammad Abbas Malik      Assistant Professor                     abas.malik@coetbgsbu.org");
        arrayListEce.add("Mrs. Farkhanda Ana            Assistant Professor                     ana.farkhanda@coetbgsbu.org");
        arrayListEce.add("Mr. Sahil Hamid               Assistant Professor ");
        arrayListEce.add("Mr. Praveen Kumar             Assistant Professor                     kumarpraveensingh90@gmail.com");
        arrayListEce.add("Ms. Tanmoya Ghosh             Assistant Professor   ");
        arrayListEce.add("Mr. Suhaib Ahmed Batt         Assistant Professor                     sabatt@outlook.com");
        arrayListEce.add("Mr. Rahul Ratnakumar          Assistant Professor                     rahulrr1986gmail.com");
        arrayListEce.add("Mr. Manik Groach              Lecturer                                manikgroach@coetbgsbu.org");
        arrayListEce.add("Ms. Nisha Gupta               Lecturer                                nishaguptaec006@coetbgsbu.org");
        arrayListEce.add("Mrs. Shaveta Puri             Lecturer    ");
        ArrayAdapter adapter = new ArrayAdapter(Ece.this, android.R.layout.simple_list_item_1,arrayListEce);
        //Map the listview to adapter
        listViewEce.setAdapter(adapter);



    }
}
