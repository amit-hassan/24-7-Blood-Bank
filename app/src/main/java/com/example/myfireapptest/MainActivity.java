package com.example.myfireapptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    //Variable Declearation
    private Button saveDataButton;
    private RadioGroup radioGroup;
    private RadioButton genderButton;
    private EditText nameEditText, emailEditText, passwordEditText, mobileEditText, addressEditText;
    DatabaseReference databaseReference;

    private FirebaseAuth mAuth;

    String[] bloodGroup;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        bloodGroup = getResources().getStringArray(R.array.blood_group);

        databaseReference = FirebaseDatabase.getInstance().getReference("students");

        //Finding All variable
        saveDataButton = findViewById(R.id.saveButtonId);
        nameEditText = findViewById(R.id.nameEditTextId);
        emailEditText = findViewById(R.id.emailEditTextId);
        passwordEditText = findViewById(R.id.passwordEditTextId);
        mobileEditText = findViewById(R.id.mobileEditTextId);
        addressEditText = findViewById(R.id.addressEditTextId);
        radioGroup = findViewById(R.id.radioGroupId);
        //For Spinner Blood Group
        spinner = findViewById(R.id.spinnerId);
        //For showing single view
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.sample_view, R.id.textViewSampleId, bloodGroup);
        spinner.setAdapter(adapter);

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
                saveData();
            }
        });


    }

    public void createUser() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter your E-mail address", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter your Password", Toast.LENGTH_LONG).show();
        }
        if (password.length() == 0) {
            Toast.makeText(getApplicationContext(), "Please enter your Password", Toast.LENGTH_LONG).show();
        }
        if (password.length() < 8) {
            Toast.makeText(getApplicationContext(), "Password must be more than 8 digit", Toast.LENGTH_LONG).show();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_LONG).show();
                            } else {
                                startActivity(new Intent(MainActivity.this, SignInActivity.class));
                                finish();
                            }
                        }


                    });

        }
    }

    public void saveData() {
        //Get data from user and store data to database
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String mobile = mobileEditText.getText().toString().trim();
        String address = addressEditText.getText().toString().trim();
        //For RadioButton
        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderButton = findViewById(selectedId);
        String radioValue = genderButton.getText().toString();

        //For BloodGroup Spinner
        String spinnerValue = spinner.getSelectedItem().toString();


        String key = databaseReference.push().getKey();

        Student student = new Student(name, email, password, mobile, address, radioValue, spinnerValue);
        databaseReference.child(key).setValue(student);
        Toast.makeText(getApplicationContext(), "Successfully info is added", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this,SignInActivity.class);
        startActivity(intent);

        nameEditText.setText("");
        emailEditText.setText("");
        passwordEditText.setText("");
        mobileEditText.setText("");
        addressEditText.setText("");
    }
}



