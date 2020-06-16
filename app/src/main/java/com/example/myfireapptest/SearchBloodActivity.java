package com.example.myfireapptest;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchBloodActivity extends AppCompatActivity {

    private RecyclerView searchRecyclerView;
    DatabaseReference databaseReference;
    private List<Request> requestList;
   // private ImageView imageView;
    private SearchBloodAdapter searchBloodAdapter; //making object for Adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_blood);

       /* //adding back button to the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);*/

      // searchBloodAdapter = new SearchBloodAdapter(getApplicationContext(),requestList,image);

       searchRecyclerView = findViewById(R.id.searchRecyclerViewId);

        searchRecyclerView.setAdapter(searchBloodAdapter);
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestList = new ArrayList<>();
        searchBloodAdapter = new SearchBloodAdapter(SearchBloodActivity.this,requestList);

        databaseReference = FirebaseDatabase.getInstance().getReference("requests");

        /*databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Request s = dataSnapshot1.getValue(Request.class);
                    requests.add(s);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(SearchBloodActivity.this, "oppsss....Something is wrong.", Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                requestList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Request request = dataSnapshot1.getValue(Request.class);
                    requestList.add(request);
                }

                searchRecyclerView.setAdapter(searchBloodAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(SearchBloodActivity.this, "ooppss...something wrong", Toast.LENGTH_SHORT).show();

            }
        });

        super.onStart();
    }

    /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }*/
}
