package com.example.needfiller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Donate extends AppCompatActivity implements View.OnClickListener {
    Button donate;
    EditText name,type, desc, phone,location;

    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);

        donate = findViewById(R.id.donate);

        name = findViewById(R.id.Name);
        type = findViewById(R.id.Items_type);
        desc = findViewById(R.id.Description);
        phone = findViewById(R.id.Phone);
        location = findViewById(R.id.Location);

        donate.setOnClickListener(this);

        text = findViewById(R.id.temp);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        if (v.findViewById(R.id.donate)==donate){
        text.setText("Name : "+name.getText().toString()+"\n Type :"+type.getText().toString()+"\n desc :"+desc.getText().toString()+"\n phone :"+phone.getText().toString()+"\n location :"+location.getText().toString());
        }
    }
}