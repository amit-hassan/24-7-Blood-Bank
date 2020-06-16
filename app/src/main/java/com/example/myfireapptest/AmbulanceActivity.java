package com.example.myfireapptest;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AmbulanceActivity extends AppCompatActivity {

    private ListView listView;
    private String[] ambulanceNames;
    private String[] ambulanceDescription;
    private int flag = R.drawable.call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

      /*  //Hiding The Title Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hiding The Action Bar
        getSupportActionBar().hide();*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);

        //adding back button to the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ambulanceNames = getResources().getStringArray(R.array.ambulance_name);

        ambulanceDescription = getResources().getStringArray(R.array.ambulance_desc);

        listView = findViewById(R.id.listViewId);

        CustomAdapter adapter = new CustomAdapter(this,ambulanceNames,ambulanceDescription,flag);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
