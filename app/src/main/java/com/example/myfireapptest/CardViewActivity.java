package com.example.myfireapptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.navigation.NavigationView;



public class CardViewActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private CardView requestBloodCardView,searchBloodCardView,allDonorCardView,ambulanceCardView,newFeedCardView,facebookGroupCardView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);


        requestBloodCardView = findViewById(R.id.bloodRequestId);
        searchBloodCardView = findViewById(R.id.searchBloodId);
        allDonorCardView = findViewById(R.id.allDonorId);
        ambulanceCardView = findViewById(R.id.ambulanceId);
        newFeedCardView = findViewById(R.id.newsFeedId);
        facebookGroupCardView = findViewById(R.id.fbGroupId);

        drawerLayout = findViewById(R.id.drawerId);

        NavigationView navigationView = findViewById(R.id.navigationId);
        navigationView.setNavigationItemSelectedListener(this);

        //Hamberger Icon
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //display the Hamberger Icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        requestBloodCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BloodRequestActivity.class);
                startActivity(intent);
            }
        });

        searchBloodCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SearchBloodActivity.class);
                startActivity(intent);
            }
        });

        allDonorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AllDonorActivity.class);
                startActivity(intent);
            }
        });

        ambulanceCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AmbulanceActivity.class);
                startActivity(intent);
            }
        });

        facebookGroupCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FacebookGroupActivity.class);
                startActivity(intent);
            }
        });

        newFeedCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NewsFeedActivity.class);
                startActivity(intent);
            }
        });



    }




//    public void onClick(View v) {
//
//        Intent intent;
//        switch (v.getId())
//        {
//            case R.id.bloodRequestId:
//            {
//                intent = new Intent(this,BloodRequestActivity.class);
//                startActivity(intent);
//                break;
//            }
//
//            case R.id.searchBloodId:
//            {
//                intent = new Intent(this,SearchBloodActivity.class);
//                startActivity(intent);
//                break;
//            }
//
//            case R.id.allDonorId:
//            {
//                intent = new Intent(this,AllDonorActivity.class);
//                startActivity(intent);
//                break;
//            }
//
//            case R.id.ambulanceId:
//            {
//                intent = new Intent(this,AmbulanceActivity.class);
//                startActivity(intent);
//                break;
//            }
//
//            case R.id.newsFeedId:
//            {
//                intent = new Intent(this,NewsFeedActivity.class);
//                startActivity(intent);
//                break;
//            }
//
//            case R.id.fbGroupId:
//            {
//                intent = new Intent(this,FacebookGroupActivity.class);
//                startActivity(intent);
//                break;
//            }
//
//        }
//    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Intent intent;

        if(menuItem.getItemId() == R.id.homeMenuId){
            intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
        }

        else if(menuItem.getItemId() == R.id.chatMenuId){
            intent = new Intent(this,ChatActivity.class);
            startActivity(intent);
        }
        return false;
    }

}
