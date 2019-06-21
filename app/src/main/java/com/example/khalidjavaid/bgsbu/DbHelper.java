package com.example.khalidjavaid.bgsbu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DbHelper extends SQLiteOpenHelper {
    public static final String Db_Name="Bgs.db";
//Cuk.db
    public DbHelper(Context context) {
        super(context, Db_Name, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table  IF NOT EXISTS Events (day text ,month text , year text,description text,type text) ");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Events");
        onCreate(db);




    }

    public boolean insertinDb(String day,String month,String desc,String type,String year)
    {
        SQLiteDatabase db= this.getReadableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("day",day);
        cv.put("description",desc);
        cv.put("month",month);
        cv.put("type",type);
        cv.put("year",year);
        long i =db.insert("Events",null,cv);
        if (i>0)
            return true;
        return false;
    }


    public Cursor GetData(String month, String year)
    {

        SQLiteDatabase db= this.getReadableDatabase();
        if(month.equals("x"))
        {

            Cursor csr=db.rawQuery("Select  * from Events ",null);
            return csr;
        }
        else {

            Cursor csr = db.rawQuery("Select  * from Events " + "where month='" + month + "'", null);
            return csr;
        }


    }

    public void cleanData()
    {
        SQLiteDatabase db= this.getReadableDatabase();
        String query="";
        db.execSQL("delete from Events");


    }

}