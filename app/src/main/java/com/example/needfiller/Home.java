package com.example.needfiller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {

    Button about_us, contact_us, receiver, donor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        about_us = findViewById(R.id.about_us);
        contact_us = findViewById(R.id.contact_us);
        receiver = findViewById(R.id.receiver);
        donor = findViewById(R.id.donor);

        about_us.setOnClickListener(this);
        contact_us.setOnClickListener(this);
        receiver.setOnClickListener(this);
        donor.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.findViewById(R.id.about_us) == about_us) {

            startActivity(new Intent(this, AboutUs.class));

        } else if (v.findViewById(R.id.contact_us) == contact_us) {

            startActivity(new Intent(this, ContactUs.class));

        } else if (v.findViewById(R.id.receiver) == receiver) {

            startActivity(new Intent(this, Receiver.class));

        } else if (v.findViewById(R.id.donor) == donor) {

            startActivity(new Intent(this, Donate.class));

        }


    }
}