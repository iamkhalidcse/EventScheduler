package com.example.khalidjavaid.bgsbu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class  Directory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        final ListView listViewDirectory = findViewById(R.id.Directory_ListView);
        ArrayList arrayListDirectory = new ArrayList();

        arrayListDirectory.add("Dept. of Computer Science And Engineering");
        arrayListDirectory.add("Dept. of Information Technology And Telecom Engineering");
        arrayListDirectory.add("Dept. of Electronics And Communication Engineering");
        arrayListDirectory.add("Dept. of Electrical And Renewable Resources Engineering");
        arrayListDirectory.add("Dept. of Civil Engineering");


        Log.e("status", "list Populated");

        ArrayAdapter adapter = new ArrayAdapter(Directory.this, android.R.layout.simple_list_item_1,arrayListDirectory);

        //Map the listView to adapter
        listViewDirectory.setAdapter(adapter);


        listViewDirectory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Log.e("status", "item clicked...");


//                Long val=listViewDirectory.getItemIdAtPosition(position);
//
//                String n=val.toString();
//
//                Toast.makeText(Directory.this,n, Toast.LENGTH_SHORT).show();

                if (id==0)
                {
                    Intent intent=new Intent(Directory.this,Cse.class);
                    startActivity(intent);
                }

               else if (id==1)
                {
                    Intent intent=new Intent(Directory.this,Ite.class);
                    startActivity(intent);
                }
               else if (id==2)
                {
                    Intent intent=new Intent(Directory.this,Ece.class);
                    startActivity(intent);
                }
               else if (id==3)
                {
                    Intent intent=new Intent(Directory.this,Ere.class);
                    startActivity(intent);
                }

               else if(id==4)
                {
                    Intent intent=new Intent(Directory.this,Civil.class);
                    startActivity(intent);
                }




            }



    });





    }
}
