package com.example.recyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    ArrayList<Contact> contactArrayList = new ArrayList<>();
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        activityMainBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activityMainBinding.edtName.getText().toString().trim().equals("") ||
                 activityMainBinding.edtPhone.getText().toString().trim().equals(""))
                    Toast.makeText(MainActivity.this,"Please Give Data",
                            Toast.LENGTH_LONG).show();
                else {

                    String name, phoneNumber;

                    name  = activityMainBinding.edtName.getText().toString().trim();
                    phoneNumber = activityMainBinding.edtPhone.getText().toString().trim();

                    Contact temp = new Contact(name,phoneNumber);
                    contactArrayList.add(temp);
                    contactAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    public void initialize(){

        activityMainBinding = DataBindingUtil.setContentView(MainActivity.this,
                R.layout.activity_main);
        activityMainBinding.recyclerView.setHasFixedSize(true);
        activityMainBinding.recyclerView.setLayoutManager
                (new LinearLayoutManager(this));
        contactAdapter = new ContactAdapter(contactArrayList);
        activityMainBinding.recyclerView.setAdapter(contactAdapter);
    }
}
