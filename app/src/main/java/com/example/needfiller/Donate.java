package com.example.needfiller;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Donate extends AppCompatActivity implements View.OnClickListener {
    Button donate;
    EditText name, type, desc, phone, location;

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
        if (v.findViewById(R.id.donate) == donate) {
            String nameValue = name.getText().toString().trim();
            String typeValue = type.getText().toString().trim();
            String descValue = desc.getText().toString().trim();
            String phoneValue = phone.getText().toString().trim();
            String locationValue = location.getText().toString().trim();


            FirebaseFirestore db = FirebaseFirestore.getInstance();

//
//            Map<String, Object> data = new HashMap<>();
//            data.put("name", nameValue);
//            data.put("type", typeValue);
//            data.put("desc", descValue);
//            data.put("phone", phoneValue);
//            data.put("location", locationValue);
//
//            db.collection("Donations").document("LA")
//                    .set(data)
//                    .addOnSuccessListener(aVoid -> {
//                            Log.d(TAG, "DocumentSnapshot successfully written!");
//                        Toast.makeText(Donate.this, "data added to db", Toast.LENGTH_SHORT).show();
//
//                    })
//                    .addOnFailureListener(e -> {
//                            Log.w(TAG, "Error writing document", e);
//                        AlertDialog.Builder builder = new AlertDialog.Builder(Donate.this);
//                        builder.setMessage(e + "");
//                        builder.setTitle("error");
//                        builder.show();
//                        Toast.makeText(Donate.this, "error", Toast.LENGTH_SHORT).show();
//
//                    });

            Data data = new Data(nameValue, typeValue, descValue, phoneValue, locationValue, Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid());
            db.collection("Donations").add(data);
            Toast.makeText(this, "data added to db", Toast.LENGTH_SHORT).show();

//            text.setText("Name : "+name.getText().toString()+"\n Type :"+type.getText().toString()+"\n desc :"+desc.getText().toString()+"\n phone :"+phone.getText().toString()+"\n location :"+location.getText().toString());
        }
    }
}


