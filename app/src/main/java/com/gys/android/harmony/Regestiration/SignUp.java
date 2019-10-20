package com.gys.android.harmony.Regestiration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.gys.android.harmony.R;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {
    private EditText uname, unum, upass, urpass;
    private String unames, upasss, urpasss, phone;

    ProgressDialog progressDialog;

    DatabaseReference rootRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //edit texts declaration
        uname = findViewById(R.id.uname);
        unum = findViewById(R.id.unum);
        upass = findViewById(R.id.upass);
        urpass = findViewById(R.id.urepass);

        //progress dialog
        progressDialog = new ProgressDialog(this);

        //firebase things
        rootRef = FirebaseDatabase.getInstance().getReference();

        // create btn
        Button btn = findViewById(R.id.signupbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }

    private void createAccount() {

        //strings
        unames = uname.getText().toString().trim();
        phone = unum.getText().toString();
        upasss = upass.getText().toString().trim();
        urpasss = urpass.getText().toString().trim();
        //checking data fields
        if (TextUtils.isEmpty(unames) || TextUtils.isEmpty(upasss) || TextUtils.isEmpty(urpasss) || TextUtils.isEmpty(String.valueOf(phone))) {
            Toast.makeText(this, "Check data", Toast.LENGTH_LONG).show();
        } else if (phone.length() != 11 || !phone.startsWith("01")) {
            Toast.makeText(this, "Wrong Phone number", Toast.LENGTH_LONG).show();
        } else if (!upasss.equals(urpasss)) {
            Toast.makeText(this, "The passwords are not identical", Toast.LENGTH_LONG).show();
        } else {
            progressDialog.setTitle("Creating an account");
            progressDialog.setMessage("Please wait ... ");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            checkData();

        }
    }

    private void checkData() {
        String type = getIntent().getStringExtra("type");
        if (type.equalsIgnoreCase("rescuer")) {
            rootRef.child("Rescuer").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (!(dataSnapshot.child(phone).exists())) {

                        final HashMap<String, Object> usersMap = new HashMap<>();
                        usersMap.put("name", unames);
                        usersMap.put("phone", phone);
                        usersMap.put("password", upasss);
                        rootRef.child("Users").child(phone).updateChildren(usersMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(SignUp.this, Login.class);
                                    intent.putExtra("type", "rescuer");
                                    startActivity(intent);
                                    progressDialog.dismiss();
                                    finish();
                                } else {
                                    progressDialog.dismiss();
                                    Toast.makeText(SignUp.this, "Error : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(SignUp.this, "This user exists", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUp.this, Login.class);
                        intent.putExtra("type", "rescuer");

                        startActivity(intent);
                        Toast.makeText(SignUp.this, "Please sign in", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }else if (type.equalsIgnoreCase("hero")){
            rootRef.child("Hero").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (!(dataSnapshot.child(phone).exists())) {

                        final HashMap<String, Object> usersMap = new HashMap<>();
                        usersMap.put("name", unames);
                        usersMap.put("phone", phone);
                        usersMap.put("password", upasss);
                        rootRef.child("Users").child(phone).updateChildren(usersMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(SignUp.this, Login.class);
                                    intent.putExtra("type", "hero");
                                    startActivity(intent);
                                    progressDialog.dismiss();
                                    finish();
                                } else {
                                    progressDialog.dismiss();
                                    Toast.makeText(SignUp.this, "Error : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(SignUp.this, "This user exists", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUp.this, Login.class);
                        intent.putExtra("type", "hero");
                        startActivity(intent);
                        Toast.makeText(SignUp.this, "Please sign in", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        }
    }

}
