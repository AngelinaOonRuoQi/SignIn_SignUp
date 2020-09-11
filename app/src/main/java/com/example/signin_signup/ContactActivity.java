package com.example.signin_signup;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactActivity extends AppCompatActivity {

    Button phone;
    Button gmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contact);
        phone = findViewById(R.id.button_phone);
        phone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0356789999"));
                startActivity(callIntent);
            }
        });

        gmail = findViewById(R.id.button_gmail);
        gmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("mailto:lifestylelibrary77@gmail.com"));
                startActivity(intent);

            }
        });


    }



}