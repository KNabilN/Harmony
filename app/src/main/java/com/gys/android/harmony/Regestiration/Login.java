package com.gys.android.harmony.Regestiration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import io.paperdb.Paper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.gys.android.harmony.Ideas.CreateIdeas;
import com.gys.android.harmony.Ideas.ShowIdeas;
import com.gys.android.harmony.Model.Users;
import com.gys.android.harmony.Prevalent.Prevalent;
import com.gys.android.harmony.R;
import com.gys.android.harmony.UserUsage.UserUsageActivity;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private EditText passE, phoneE;
    private TextView signUp;
    private Button loginB;
    private String password, phone;
    private DatabaseReference rootRef;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Defining
        passE = findViewById(R.id.passeditli);
        loginB = findViewById(R.id.loginbtn);
        signUp = findViewById(R.id.signup);
        phoneE = findViewById(R.id.phoneeditli);

        progressDialog = new ProgressDialog(this);
//firebase
        rootRef = FirebaseDatabase.getInstance().getReference();

        //to save data
        Paper.init(this);


        loginB.setOnClickListener(this);
        signUp.setOnClickListener(this);
//        forgetT.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //strings
        password = passE.getText().toString();
        phone = phoneE.getText().toString();

        if (v == loginB) {
            progressDialog.setTitle("Wait please ...");
            progressDialog.setCanceledOnTouchOutside(false);
            login();
        }


        if (v == signUp) {
            Intent intent = new Intent(Login.this, SignUp.class);
            startActivity(intent);
            finish();

        }

//        if (v == forgetT) {
////            Intent intent = Intent(Main2Activity.this , Forget);
////            startActivity(intent);
////            finish();
//        }
    }

    private void login() {
        //data check
       if (TextUtils.isEmpty(password) || TextUtils.isEmpty(phone)) {
            Toast.makeText(Login.this, "Please enter your data", Toast.LENGTH_LONG).show();
            progressDialog.dismiss();

            //phone check
        } else if (phone.length() != 11 || !phone.startsWith("01")) {
            Toast.makeText(this, "Invalid phone number", Toast.LENGTH_LONG).show();

        } else {
            progressDialog.show();

//  check if exist and save data
           String type = getIntent().getStringExtra("type");
           if (type.equalsIgnoreCase("rescuer")) {
               rootRef.child("Rescuer").addListenerForSingleValueEvent(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       if (dataSnapshot.child(phone).exists()) {

                           rootRef.child("Rescuer").child(phone).addListenerForSingleValueEvent(new ValueEventListener() {
                               @Override
                               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                   Users user = dataSnapshot.getValue(Users.class);
                                   if (user.getPassword().equalsIgnoreCase(password)) {
                                       Paper.book().destroy();
                                       Paper.book().write(Prevalent.UserPassword, password);
                                       Paper.book().write(Prevalent.UserPhone, phone);
                                       Paper.book().write(Prevalent.currentUser, user.getName());


                                       Intent intent = new Intent(Login.this, UserUsageActivity.class);
                                       startActivity(intent);
                                       progressDialog.dismiss();
                                       finish();
                                   } else {
                                       progressDialog.dismiss();
                                       Toast.makeText(Login.this, "Wrong password", Toast.LENGTH_SHORT).show();

                                   }
                               }

                               @Override
                               public void onCancelled(@NonNull DatabaseError databaseError) {

                               }
                           });

                       } else {
                           Toast.makeText(Login.this, "This Phone os not registered ... please sign up", Toast.LENGTH_SHORT).show();

                           Intent intent = new Intent(Login.this, SignUp.class);
                           intent.putExtra("type", "hero");
                           startActivity(intent);
                           progressDialog.dismiss();
                           finish();
                       }
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });
           }else if (type.equalsIgnoreCase("hero")) {
               rootRef.child("Hero").addListenerForSingleValueEvent(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       if (dataSnapshot.child(phone).exists()) {

                           rootRef.child("Hero").child(phone).addListenerForSingleValueEvent(new ValueEventListener() {
                               @Override
                               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                   Users user = dataSnapshot.getValue(Users.class);
                                   if (user.getPassword().equalsIgnoreCase(password)) {
                                       Paper.book().destroy();
                                       Paper.book().write(Prevalent.UserPassword, password);
                                       Paper.book().write(Prevalent.UserPhone, phone);
                                       Paper.book().write(Prevalent.currentUser, user.getName());


                                       Intent intent = new Intent(Login.this, CreateIdeas.class);
                                       startActivity(intent);
                                       progressDialog.dismiss();
                                       finish();
                                   } else {
                                       progressDialog.dismiss();
                                       Toast.makeText(Login.this, "Wrong password", Toast.LENGTH_SHORT).show();

                                   }
                               }

                               @Override
                               public void onCancelled(@NonNull DatabaseError databaseError) {

                               }
                           });

                       } else {
                           Toast.makeText(Login.this, "This Phone os not registered ... please sign up", Toast.LENGTH_SHORT).show();

                           Intent intent = new Intent(Login.this, SignUp.class);
                           intent.putExtra("type", "hero");
                           startActivity(intent);
                           progressDialog.dismiss();
                           finish();
                       }
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });
           }

       }
    }

}
