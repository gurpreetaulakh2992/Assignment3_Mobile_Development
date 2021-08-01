package com.example.sqliteapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class viewDataActivity extends AppCompatActivity {

    DBHelper DB;
    ArrayList<ListData> myData;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        initializeComponent();
        showData();
    }

    private void showData() {
        Cursor res = DB.getdata();
        if(res.getCount() == 0){
            Toast.makeText(viewDataActivity.this, "Nothing existed!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(viewDataActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else {
            while(res.moveToNext()) {

                myData.add(new ListData(
                        "Name: " + res.getString(0) + "\n",
                        "Contact: " + res.getString(1) + "\n",
                        "Date of Birth: " + res.getString(2) + "\n\n\n"));
            }
        }
        ListAdapter adapter = new ListAdapter(myData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void initializeComponent()
    {
        DB = new DBHelper(this);
        myData=new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

}
