package com.example.signin_signup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingChangePassword extends AppCompatActivity {

    private EditText newPassword,confirmPassword;
    private Button confirm,cancel;
    private FirebaseAuth firebaseAuth;
    private TextView back;
    private AuthCredential credential;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_change_password);

        confirmPassword=(EditText) findViewById(R.id.confirmPassword);
        newPassword=(EditText) findViewById(R.id.confirmPassword);
        confirm=(Button) findViewById(R.id.btnConfirm);
        cancel=(Button) findViewById(R.id.btnCancel);
        back = (TextView) findViewById(R.id.textView9);


        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser users = firebaseAuth.getCurrentUser();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPass = newPassword.getText().toString().trim();
                String conPass = confirmPassword.getText().toString().trim();

                if (newPass.isEmpty()|conPass.isEmpty()){
                    newPassword.setError("Please fill in the blank");
                    confirmPassword.setError("Please fill in the blank");
                }
                else if(newPass.equals(conPass)){
                    setUserPassword(newPassword);
                }
                else{
                    Toast.makeText(SettingChangePassword.this, "Password Update Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Setting.class);
                startActivity(intent);
            }
        });



        cancel.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Setting.class);
                startActivity(intent);
            }
        }));

    }

    public void setUserPassword(View view){
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String newPass = newPassword.getText().toString();
        if (TextUtils.isEmpty(newPass))
            return;

        user.updatePassword(newPass)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                            Toast.makeText(SettingChangePassword.this, "Password Updated", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(SettingChangePassword.this, "Password Update Failed", Toast.LENGTH_SHORT).show();
                    }
                });

        }
    }
