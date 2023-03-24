package com.example.needfiller;

import static com.example.needfiller.Signup.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ContactUs extends AppCompatActivity implements View.OnClickListener {

    EditText name, sub, msg;
    Button ask;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        if (user == null) {
            startActivity(new Intent(getApplicationContext(), Login.class));
        }

        name = findViewById(R.id.name);
        sub = findViewById(R.id.sub);
        msg = findViewById(R.id.msg);

        ask = findViewById(R.id.ask);
        ask.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.findViewById(R.id.ask) == ask) {
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            String nameValue = name.getText().toString().trim();
            String subValue = sub.getText().toString().trim();
            String msgValue = msg.getText().toString().trim();

            if (!nameValue.equals("") || !subValue.equals("") || !msgValue.equals("")) {
                Map<String, Object> data = new HashMap<>();
                data.put("name", nameValue);
                data.put("sub", subValue);
                data.put("msg", msgValue);
                data.put("user", user.getEmail());


                db.collection("Contact").add(data)
                        .addOnSuccessListener(aVoid -> {
                            Log.d(TAG, "DocumentSnapshot successfully written!(Contact us)");
                            Toast.makeText(this, "We will update you soon", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Home.class));
                        })
                        .addOnFailureListener(e -> {
                            Log.w(TAG, "Error adding Contact", e);
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setMessage(e + "");
                            builder.setTitle("Error adding Contact");
                            builder.show();
                            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();

                        });
            } else {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}