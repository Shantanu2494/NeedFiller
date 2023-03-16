package com.example.needfiller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements View.OnClickListener {

    Button about_us, contact_us, receiver, donor, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        about_us = findViewById(R.id.about_us);
        contact_us = findViewById(R.id.contact_us);
        receiver = findViewById(R.id.receiver);
        donor = findViewById(R.id.donor);
        logout = findViewById(R.id.logout);

        about_us.setOnClickListener(this);
        contact_us.setOnClickListener(this);
        receiver.setOnClickListener(this);
        donor.setOnClickListener(this);
        logout.setOnClickListener(this);

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

        } else if (v.findViewById(R.id.logout) == logout) {
            
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Login.class));

        }


    }
}