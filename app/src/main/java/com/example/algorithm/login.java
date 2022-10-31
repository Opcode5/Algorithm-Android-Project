package com.example.algorithm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    EditText email,password;
    ImageButton login;
    FirebaseAuth fauth;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        login=(ImageButton) findViewById(R.id.login);
        text=(TextView) findViewById(R.id.textt);
        fauth=FirebaseAuth.getInstance();
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),register.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=email.getText().toString().trim();
                String pass=password.getText().toString();
                if(TextUtils.isEmpty(mail))
                {
                    Toast.makeText(login.this, "email is empty", Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(TextUtils.isEmpty(pass))
                {
                    Toast.makeText(login.this, "password is required", Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(pass.length()<6)
                {
                    Toast.makeText(login.this, "password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                    return ;
                }
                fauth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(login.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),likhon.class));
                        }
                        else
                        {
                            Toast.makeText(login.this, "Log in is unsuccessfull", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
