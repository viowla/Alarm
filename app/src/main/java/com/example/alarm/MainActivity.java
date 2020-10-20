package com.example.alarm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    ListView listView;
    Button add;
    String[] title ={"8:00","12:00","9:00","6:15"};
    String[] subtitle ={"Wake up","Lunch time","Sleeping",""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //alarms list
        listView = findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(this,title, subtitle);
        listView.setAdapter(myAdapter);

        Intent intent = getIntent();
        subtitle = intent.getStringArrayExtra("strings");

        //button add alarm
        add = findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), SetAlarmActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        //single list item click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                new AlertDialog.Builder(MainActivity.this).setPositiveButton("Ok", null)
                        .setMessage("24 hours left"+position).show();
            }
        });

        //long click list item
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {


                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                            @Override
                                    public void onClick(DialogInterface dialog, int which){
                                listView.removeViewAt(position);
                                myAdapter.notifyDataSetChanged();

                    }
                })
                .setNegativeButton("No", null)
                .show();

                return true;
            }
        });

    }



    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] title;
        String[] subtitle;

        public MyAdapter(Context c, String[] title, String[] subtitle){
            super(c, R.layout.row,R.id.textView, title);
            this.context=c;
            this.title=title;
            this.subtitle=subtitle;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater;
            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            TextView textView1 = row.findViewById(R.id.textView);

            TextView textView2 = row.findViewById(R.id.alarmName);


            textView1.setText(title[position]);
            textView2.setText(subtitle[position]);

            return row;
        }
    }
}