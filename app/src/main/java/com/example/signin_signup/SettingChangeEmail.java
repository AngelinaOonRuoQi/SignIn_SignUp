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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingChangeEmail extends AppCompatActivity {

    private TextView back;
    private Button confirm;
    private Button cancel;
    private FirebaseAuth firebaseAuth;
    private EditText email;

    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_change_email);
        final FirebaseAuth auth = FirebaseAuth.getInstance();

        confirm = (Button) findViewById(R.id.btnConfirm);
        cancel = (Button) findViewById(R.id.btnCancel);
        email = (EditText) findViewById((R.id.txtEmail));
        back = (TextView) findViewById(R.id.textView7);


        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = firebaseAuth.getCurrentUser();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newEmail = email.getText().toString().trim();

                if (newEmail.isEmpty()){
                    email.setError("Please fill in the blank");
                }
                else {
                    setUserEmailAdd(email);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), Setting.class);
            startActivity(intent);
        }
    });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Setting.class);
                startActivity(intent);
            }
        });

    }

    public void setUserEmailAdd(View view){
        String newEmail=email.getText().toString();
        if (TextUtils.isEmpty(newEmail))
            return;

        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();

        if (user == null)
            return;

        user.updateEmail(newEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                    Toast.makeText(SettingChangeEmail.this, "Email Updated", Toast.LENGTH_SHORT).show();
            }
        });


    }
}