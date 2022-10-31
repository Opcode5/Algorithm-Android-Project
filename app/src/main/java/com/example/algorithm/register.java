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

public class register extends AppCompatActivity {

    EditText name,email,password;
    ImageButton register;
    ProgressBar pbar;
    FirebaseAuth fauth;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        register=(ImageButton) findViewById(R.id.register);
        text=(TextView) findViewById(R.id.textt);
        pbar=(ProgressBar) findViewById(R.id.progressBar);
        fauth=FirebaseAuth.getInstance();
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namee=name.getText().toString().trim();
                String mail=email.getText().toString().trim();
                String pass=password.getText().toString();
                if(TextUtils.isEmpty(namee))
                {
                    Toast.makeText(register.this, "name is empty", Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(TextUtils.isEmpty(mail))
                {
                    Toast.makeText(register.this, "email is empty", Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(TextUtils.isEmpty(pass))
                {
                    Toast.makeText(register.this, "password is required", Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(pass.length()<6)
                {
                    Toast.makeText(register.this, "password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                    return ;
                }
                pbar.setVisibility(View.VISIBLE);
                fauth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(register.this, "Registration is successfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),likhon.class));
                        }
                        else
                        {
                            Toast.makeText(register.this, "Registration is unsuccessfull", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
