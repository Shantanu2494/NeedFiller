package com.example.needfiller;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.Objects;

public class Signup extends AppCompatActivity {


    public static final String TAG = "TAG";
    EditText username, mEmail, mPassword;
    Button registerBtn;
    TextView loginBtn;
    ProgressBar progressBar;
    String userID;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        username = findViewById(R.id.fullname);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        registerBtn = findViewById(R.id.registerbtn);
        loginBtn = findViewById(R.id.createtext);
        progressBar = findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null) {

            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        loginBtn.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Login.class)));

        registerBtn.setOnClickListener(view -> {
            final String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                mEmail.setError("Email is Required");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                mPassword.setError("Password is Required");
                return;
            }

            if (password.length() < 6) {
                mPassword.setError("Password must be >=6 character");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

                if (task.isSuccessful()) {
                    FirebaseUser user = fAuth.getCurrentUser();
                    assert user != null;


                    user.sendEmailVerification().addOnSuccessListener(unused ->
                            Toast.makeText(getApplicationContext(), "Register Successful",
                                    Toast.LENGTH_SHORT).show()).addOnFailureListener(e ->
                            Log.d(TAG, "On failure: Email Not Sent" + e.getMessage()));

                    Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();

                    userID = user.getUid();


                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(username.getText().toString())
                            .build();

                    user.updateProfile(profileUpdates)
                            .addOnCompleteListener(task1 -> {
                                if (task1.isSuccessful()) {
                                    Log.d(TAG, "User profile updated.");
                                }
                            });

                    startActivity(new Intent(getApplicationContext(), Home.class));

                } else {
                    Toast.makeText(Signup.this, "Error" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.GONE);

            });
        });


    }
}