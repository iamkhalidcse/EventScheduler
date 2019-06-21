package com.example.khalidjavaid.bgsbu;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog pDialog;
    DbHelper Mydb=new DbHelper(this);
    // URL to get contacts JSON
    //private static String url = "http://www.cukashmir.somee.com/src/json.txt";
     //private static String url = "http://10.0.2.2/eventschedule.txt";

        private static String url = "https://api.myjson.com/bins/1basbh";

    //private static String url = "http://172.20.10.4/eventschedule";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       try {
           setContentView(R.layout.activity_main);
           Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
           CompactCalendarView clw = findViewById(R.id.compactcalendar_view);
           clw.setUseThreeLetterAbbreviation(true);

           setSupportActionBar(toolbar);
           ListView list = (ListView) findViewById(R.id.list);
           ArrayList arrayList1 = new ArrayList<String>();
           ArrayAdapter adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList1);

           FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
           fab.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Snackbar.make(view, "Department of Computer Science And Engineering", Snackbar.LENGTH_LONG)
                           .setAction("Action", null).show();
               }
           });

           //initialise main activity
           TextView TextShowMonth = findViewById(R.id.TextMonth);
           Calendar c = Calendar.getInstance();
           Calendar c2 = Calendar.getInstance();
           int Month = c.get(Calendar.MONTH);
           ;
           int year = c.get(Calendar.YEAR);


           TextShowMonth.setText(showmnth(Month + 1) + " " + String.valueOf(year));
//adding events on first load
           String mnth = "";
           if (Month <= 8) {
               mnth = "0" + String.valueOf(Month + 1);

           } else {

               mnth = String.valueOf(Month + 1);
           }

           Cursor ds = Mydb.GetData(mnth, Integer.toString(year)); //cor current mnth to show in list view
           Cursor ds2 = Mydb.GetData("x", Integer.toString(year));//for all events
           String str = "", Today;
           if (ds2.getCount() != 0) {

               while (ds2.moveToNext()) {


                   c2.set(Integer.parseInt(ds2.getString(2)), Integer.parseInt(ds2.getString(1)) - 1, Integer.parseInt(ds2.getString(0)));

                   long millis = c2.getTimeInMillis();
                   Event ev1 = new Event(Color.RED, millis, ds2.getString(3));
                   clw.addEvent(ev1, false);


               }

           }
           if (ds.getCount() == 0) {
               //

           } else {
               while (ds.moveToNext()) {
                   String stryear = ds.getString(2);
                   // if (ds.getString(2).equals(Integer.toString(year)))
                   {

                       str += "day=" + ds.getString(0) + " month  =" + ds.getString(1) + "  year=" + ds.getString(2)
                               + "  desc=" + ds.getString(3) + "  type=" + ds.getString(4) + "\n";
                       Today = ds.getString(0) + "/" + ds.getString(1) + "/" + ds.getString(2);


                       SimpleDateFormat month_date = new SimpleDateFormat("DD/MM/yyyy");
                       String month_name = month_date.format(c.getTime());

                       adapter1.add(ds.getString(0) + "/" + ds.getString(1) + "/" + ds.getString(2) + "  : " + ds.getString(3));


                   }

               }


           }


           list.setAdapter(adapter1);


           clw.setListener(new CompactCalendarView.CompactCalendarViewListener() {
               @Override
               public void onDayClick(Date dateClicked) {

               }

               @Override
               public void onMonthScroll(Date firstDayOfNewMonth) {

                   {
                       Calendar c1 = Calendar.getInstance();
                       c1.setTime(firstDayOfNewMonth);
                       int Month = c1.get(Calendar.MONTH);
                       ;
                       int year = c1.get(Calendar.YEAR);

                       TextView TextShowMonth1 = findViewById(R.id.TextMonth);
                       TextShowMonth1.setText(showmnth(Month + 1) + " " + String.valueOf(year));

                       String mnth = "";
                       if (Month <= 8) {
                           mnth = "0" + String.valueOf(Month + 1);

                       } else {

                           mnth = String.valueOf(Month + 1);
                       }
                       Cursor ds1 = Mydb.GetData(mnth, Integer.toString(year));
                       //String str1="",Today;
                       //   SimpleDateFormat sdf = new SimpleDateFormat("dd/mmm/yyy");

                       ListView list1 = (ListView) findViewById(R.id.list);
                       ArrayList arrayList1 = new ArrayList<String>();
                       ArrayAdapter adapter1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList1);
                       if (ds1.getCount() == 0) {
                           //  Toast.makeText(MainActivity.this, "The Holidays for This month are not Availible!!!", Toast.LENGTH_SHORT).show();

                       } else {
                           while (ds1.moveToNext()) {
                               String stryear = ds1.getString(2);
                               if (ds1.getString(2).equals(Integer.toString(year))) {


                                   c1.set(Integer.parseInt(ds1.getString(2)), Integer.parseInt(ds1.getString(1)) - 1, Integer.parseInt(ds1.getString(0)));
                                   //long millis= c.getTimeInMillis();
                                   //Event ev1 = new Event(Color.RED,  millis,  ds.getString(3));
                                   //clw.addEvent(ev1,false);
                                   SimpleDateFormat month_date = new SimpleDateFormat("DD/MMM/yyyy");
                                   String month_name = month_date.format(c1.getTime());
                                   adapter1.add(ds1.getString(0) + "/" + ds1.getString(1) + "/" + ds1.getString(2) + "  : " + ds1.getString(3));


                               }
                           }
                           // showmsg(str);

                       }


                       list1.setAdapter(adapter1);


                   }


               }
           });
       } catch (Exception e)
       {
//           TextView t1=findViewById(R.id.Textcal);
//           t1.setText(e.getMessage());
           Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
     final    Calendar myCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                Calendar c1=Calendar.getInstance();
                c1.setTime(myCalendar.getTime());
                int Month=c1.get(Calendar.MONTH);;
               CompactCalendarView clw=findViewById(R.id.compactcalendar_view);
               clw.setCurrentDate(myCalendar.getTime());

                TextView TextShowMonth1=findViewById(R.id.TextMonth);
                TextShowMonth1.setText(showmnth(Month+1)+" / "+String.valueOf(year));

                String mnth="";
                if(Month <=8 )
                {
                    mnth="0"+String.valueOf(Month+1);

                }
                else{

                    mnth=String.valueOf(Month+1);
                }
                Cursor ds1= Mydb.GetData(mnth,Integer.toString(year));
                //String str1="",Today;
                //   SimpleDateFormat sdf = new SimpleDateFormat("dd/mmm/yyy");

                ListView list1 = (ListView) findViewById(R.id.list);
                ArrayList  arrayList1 = new ArrayList<String>();
                ArrayAdapter adapter1 = new ArrayAdapter <String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, arrayList1);
                if (ds1.getCount()==0)
                {
                    //  Toast.makeText(MainActivity.this, "The Holidays for This month are not Availible!!!", Toast.LENGTH_SHORT).show();

                }
                else {
                    while (ds1.moveToNext()) {
                        String stryear=ds1.getString(2);
                        if (ds1.getString(2).equals(Integer.toString(year)))
                        {


                            c1.set(Integer.parseInt(ds1.getString(2)),Integer.parseInt(ds1.getString(1))-1 , Integer.parseInt(ds1.getString(0)));
                            //long millis= c.getTimeInMillis();
                            //Event ev1 = new Event(Color.RED,  millis,  ds.getString(3));
                            //clw.addEvent(ev1,false);
                            SimpleDateFormat month_date = new SimpleDateFormat("DD/MMM/yyyy");
                            String month_name = month_date.format(c1.getTime());
                            adapter1.add(ds1.getString(0)+"/"+ds1.getString(1)+"/"+ds1.getString(2)+"  : "+ds1.getString(3));


                        }
                    }
                    // showmsg(str);

                }


                list1.setAdapter(adapter1);



            }
        };
        //noinspection SimplifiableIfStatement
        CompactCalendarView clw=findViewById(R.id.compactcalendar_view);
        if (id == R.id.action_sync) {

            if(haveNetworkConnection()) {
                clw.removeAllEvents();

            }
            new GetEvents().execute();
        }
        if (id == R.id.action_AboutUs) {
//code to open about us

         Intent intent=new Intent(MainActivity.this, aboutus.class);
         startActivity(intent);
           /* setContentView(R.layout.activity_aboutus);
            DisplayMetrics dm=new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            int width=dm.widthPixels;
            int height =dm.heightPixels;
            getWindow().setLayout((int)(width*.8),(int)(height*.8));
*/

        }

        if (id==R.id.action_Directory){
          //  ProgressBar bar;
           // ProgressDialog dialog;
          //  bar = findViewById(R.id.Progressbar_Main);


//            dialog = new ProgressDialog(MainActivity.this);
//            dialog.setMessage("Please wait...");
//            dialog.setCancelable(true);
//            dialog.show();
        //    bar.setVisibility(View.VISIBLE);
            Intent intent=new Intent(MainActivity.this,Directory.class);
            startActivity(intent);

        }


        if (id == R.id.action_jump) {

            new DatePickerDialog(MainActivity.this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    public void prevMonth(View view) {
        ((CompactCalendarView)findViewById(R.id.compactcalendar_view)).showPreviousMonth();
    }

    public void nextMonth(View view) {
        ((CompactCalendarView)findViewById(R.id.compactcalendar_view)).showNextMonth();
    }

    private class GetEvents extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @SuppressLint("WrongThread")
        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);
            //Adding events to calender as well
            CompactCalendarView clw1=findViewById(R.id.compactcalendar_view);
            Calendar cl=Calendar.getInstance();


            //    Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray Events = jsonObj.getJSONArray("Events");
                    Mydb.cleanData();
                    // looping through All events
                    for (int i = 0; i < Events.length(); i++) {
                        JSONObject c = Events.getJSONObject(i);

                        String day = c.getString("day");
                        String month = c.getString("month");
                        String description = c.getString("description");

                        String type=c.getString("type") ;
                        String year=c.getString("year") ;
                        //setting date to calender to get EPOC
                        cl.set(Integer.parseInt(year),  Integer.parseInt(month)-1, Integer.parseInt(day));
                        long millis= cl.getTimeInMillis();
                        Event ev1 = new Event(Color.RED,  millis, description);
                        clw1.addEvent(ev1,false);
                        Mydb.insertinDb(day,month,description,type,year);
                        //  str+=day+" - "+month+"-"+description+"-"+type+"-"+year+"\n";

                    }



                } catch (final JSONException e) {
                    //   Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                // Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't connect to  server. Check Internet Connection!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            //Toast.makeText(MainActivity.this, "Data base Updated", Toast.LENGTH_SHORT).show();
            showmsg("Task Completed");





        }
    }
    public static class HttpHandler {

        private static final String TAG = HttpHandler.class.getSimpleName();

        public HttpHandler() {
        }

        public String makeServiceCall(String reqUrl) {
            String response = null;
            try {
                URL url = new URL(reqUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                // read the response
                InputStream in = new BufferedInputStream(conn.getInputStream());
                response = convertStreamToString(in);
            } catch (MalformedURLException e) {
                Log.e(TAG, "MalformedURLException: " + e.getMessage());
            } catch (ProtocolException e) {
                Log.e(TAG, "ProtocolException: " + e.getMessage());
            } catch (IOException e) {
                Log.e(TAG, "IOException: " + e.getMessage());
            } catch (Exception e) {
                Log.e(TAG, "Exception: " + e.getMessage());
            }
            return response;
        }

        private String convertStreamToString(InputStream is) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();

            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return sb.toString();
        }
    }
    //function to print message
    public void showmsg(String msg){

        AlertDialog.Builder A1=new AlertDialog.Builder(this);
        A1.setCancelable(true);
        A1.setTitle("Alert result");
        A1.setMessage(msg);
        A1.show();

    }

    public String showmnth(int m){

        if(m==1)
        {return "January";}
        if(m==2)
        {return "February";}
        if(m==3)
        {return "March";}
        if(m==4)
        {return "April";}
        if(m==5)
        {return "May";}
        if(m==6)
        {return "June";}
        if(m==7)
        {return "July";}
        if(m==8)
        {return "August";}
        if(m==9)
        {return "September";}
        if(m==10)
        {return "October";}
        if(m==11)
        {return "November";}
        if(m==12)
        {return "December";}


        return null;
    }
}
