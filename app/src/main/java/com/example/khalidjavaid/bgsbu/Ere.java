package com.example.khalidjavaid.bgsbu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ere);


        Toast.makeText(Ere.this,"ERE", Toast.LENGTH_SHORT).show();


        final ListView  listViewEre = findViewById(R.id.EreListView);
        ArrayList arrayListEre = new ArrayList();



        arrayListEre.add("Mr.Shafqat Mughal         HOD                                 smughal.bgsbu@gmail.com");
        arrayListEre.add("Mr. Tasaduq Hussain       Assistant Professor                 justasaduq@gmail.com");
        arrayListEre.add("Mr. Yassar Arfat          Assistant Professor                 metwithyasser@yahoo.com");
        arrayListEre.add("Mr. Qamar-ul-Islam        Assistant Professor                 qamarul.islamcoetbgsbu.org");
        arrayListEre.add("Mr. Muzaffar Hussain      Assistant Professor                 muzaffarh8@gmail.com");
        arrayListEre.add("Mr. Farhad Illahi Bakhsh  Assistant Professor                 farhad.ilahi@coetbgsbu.org");
        arrayListEre.add("Mr. Ahmed Riyaz           Assistant Professor                 ahmedriyaz@coetbgsbu.org");
        arrayListEre.add("Mr. Vinod Puri            Assistant Professor           ");
        arrayListEre.add("Ms. Ankita Runani         Assistant Professor                 ankita.runani@coetbgsbu.org ");
        arrayListEre.add("Mr. Arvind Kumar Singh    Assistant Professor    ");
        arrayListEre.add("Mr. Mukesh Kumar Singh    Assistant Professor    ");
        arrayListEre.add("Mr. Ashish Kumar Mishra   Assistant Professor                 srtforeverashish@gmail.com");
        arrayListEre.add("Mr. Pankaj Kumar          Assistant Professor      ");
        arrayListEre.add("Mr. Neetan Sharma         Assistant Professor     ");
        arrayListEre.add("Mr. Shujait Ali Jafri     Assistant Professor     ");

        ArrayAdapter adapter = new ArrayAdapter(Ere.this,android.R.layout.simple_list_item_1 ,arrayListEre);
        //Map the listview to adapter
        listViewEre.setAdapter(adapter);

























    }
}
