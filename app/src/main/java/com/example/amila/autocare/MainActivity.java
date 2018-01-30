package com.example.amila.autocare;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    EditText editTextemail, editTextPassword;
    FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextemail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.textViewSignup).setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textViewSignup:
                startActivity(new Intent(this,signup.class));
                break;
            case R.id.button:
                userlogin();
                break;
        }
    }

    private void userlogin(){
        String email = editTextemail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if(password.isEmpty()){
            editTextPassword.setError("Enter Password Here");
            editTextPassword.requestFocus();
        }else if(email.isEmpty()){
            editTextemail.setError("Enter email here");
            editTextemail.requestFocus();
        }else{
           mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                       Intent intent =   new Intent(getApplicationContext(),home.class);
                       startActivity(intent);
                       intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    }else{
                        Toast.makeText(getApplicationContext(),task.getException().getMessage().toString(),Toast.LENGTH_SHORT);
                        Log.d("login","login task not successfull");
                    }
               }
           });
        }

    }
}





