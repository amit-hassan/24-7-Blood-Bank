package com.example.myfireapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BloodRequestActivity extends AppCompatActivity {

    SearchBloodAdapter searchBloodAdapter;
    //Variable Declearation
    private Button reqestButton;
    private RadioGroup requestRadioGroup;
    private RadioButton requestGenderButton;
    private EditText reqNameEditText, reqMobileEditText, reqAddressEditText,reqBloodEditText;
    DatabaseReference databaseReference;

    private FirebaseAuth mAuth;

    String[] bloodGroup,amountOfBlood;

    private Spinner spinner,requestSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_request);

       /* //adding back button to the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);*/

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        bloodGroup = getResources().getStringArray(R.array.blood_group);
        amountOfBlood = getResources().getStringArray(R.array.amount_of_blood);

       databaseReference = FirebaseDatabase.getInstance().getReference("requests");

        //Finding All variable
        reqestButton = findViewById(R.id.reqSaveButtonId);
        reqNameEditText = findViewById(R.id.reqNameEditTextId);
        reqMobileEditText = findViewById(R.id.reqMobileEditTextId);
        reqAddressEditText = findViewById(R.id.reqAddressEditTextId);
        reqBloodEditText = findViewById(R.id.reqBloodEditTextId);
        requestRadioGroup = findViewById(R.id.reqRadioGroupId);
        //For Spinner Blood Group
        spinner = findViewById(R.id.reqSpinnerId);
        //For Spinner Amount of Blood
        requestSpinner  = findViewById(R.id.reqAmountSpinnerId);

        //For showing single view
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.sample_view, R.id.textViewSampleId, bloodGroup);
        spinner.setAdapter(adapter);

        //For Amount of Blood Single View
        ArrayAdapter<String> newAdapter = new ArrayAdapter<>(this,R.layout.request_sample_view,R.id.requestViewSampleId,amountOfBlood);
        requestSpinner.setAdapter(newAdapter);



        reqestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveRequest();
                Intent intent = new Intent(BloodRequestActivity.this, SearchBloodActivity.class);
                startActivity(intent );
            }
        });

    }




    public void SaveRequest() {
        //Get data from user and store data to database
        String name = reqNameEditText.getText().toString().trim();
        String mobile = reqMobileEditText.getText().toString().trim();
        String address = reqAddressEditText.getText().toString().trim();
        String whyNeed = reqBloodEditText.getText().toString().trim();
        //For RadioButton
        int selectedId = requestRadioGroup.getCheckedRadioButtonId();
        requestGenderButton = findViewById(selectedId);
        String radioValue = requestGenderButton.getText().toString();

        //For BloodGroup Spinner
        String spinnerValue = spinner.getSelectedItem().toString();

        //Foe Amount of Blood Spinner
        String amountSpinnerValue = requestSpinner.getSelectedItem().toString();

        String key = databaseReference.push().getKey();

        Request request = new Request(name, mobile, address, whyNeed, radioValue, spinnerValue, amountSpinnerValue);
        databaseReference.child(key).setValue(request);

        Toast.makeText(getApplicationContext(), "Request Success", Toast.LENGTH_LONG).show();

        reqNameEditText.setText("");
        reqMobileEditText.setText("");
        reqAddressEditText.setText("");
        reqBloodEditText.setText("");



    }
}
