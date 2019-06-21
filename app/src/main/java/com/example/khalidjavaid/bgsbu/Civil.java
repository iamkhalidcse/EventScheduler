package com.example.khalidjavaid.bgsbu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Civil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil);
        Toast.makeText(Civil .this, "Civil",Toast.LENGTH_SHORT ).show();


     final ListView listViewCivil = findViewById(R.id.CivilListView);
        ArrayList arrayListCivil = new ArrayList();
        arrayListCivil.add("Mr. Mir Aijaz Ahmed       HOD                                    miraijazahmadcivil@gmail.com");
        arrayListCivil.add("Mr. Pervez Alam           Assistant Professor                    pervezbgsbu@coetbgsbu.org");
        arrayListCivil.add("Mr. Zeeshan Aslam         Assistant Professor    ");
        arrayListCivil.add("Mr. Nasir Ahmad Rather    Assistant Professor                    nasir3@gmail.com");
        arrayListCivil.add("Mr. Ameer-Ullah Ganai     Assistant Professor                    ameerullah@coetbgsbu.org");
        arrayListCivil.add("Mr. Shahid ul Islam       Assistant Professor                    shahidulislam@coetbgsbu.org");
        arrayListCivil.add("Mr. Azeem Javed           Assistant Professor    ");
        arrayListCivil.add("Mr. Rahul Chandan         Assistant Professor                    rahulchandan51@gmail.com");
        arrayListCivil.add("Mr. Atul Sardalia         Assistant Professor ");
        arrayListCivil.add("Mr. Sayed Sadulla Ahmed   Assistant Professor                    sadullasyed@gmail.com");
        arrayListCivil.add("Mr. Pankaj Rana           Assistant Professor                    pankajranajnv@gmail.com");
        arrayListCivil.add("Km. Sharda Gupta          Assistant Professor                    salugupta235@gmail.com");
        arrayListCivil.add("Mr. Najim Ali             Assistant Professor  ");
        arrayListCivil.add("Mr.  Satya Prakash        Assistant Professor                    prakashsatyacoer@gmail.com");
        arrayListCivil.add("Mr. Ramandeep Singh       Lecturer(contractual)    ");
        ArrayAdapter adapter = new ArrayAdapter(Civil.this, android.R.layout.simple_list_item_1,arrayListCivil);
        //Map the list view to adpater
        listViewCivil.setAdapter(adapter);



    }
}
