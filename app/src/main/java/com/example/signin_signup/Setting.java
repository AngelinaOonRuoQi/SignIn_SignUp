package com.example.signin_signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Setting extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    private TextView password;
    private TextView email;
    private TextView general;
    private TextView aboutUs;
    private TextView termsAndConditions;
    private ImageView back;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        password = (TextView) findViewById(R.id.password);
        email = (TextView) findViewById(R.id.email);
        general = (TextView) findViewById(R.id.general);
        aboutUs = (TextView) findViewById(R.id.aboutUs);
        termsAndConditions = (TextView) findViewById(R.id.termsAndConditions);
        back = (ImageView) findViewById(R.id.back);
        logout = (Button) findViewById(R.id.logout);

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingChangePassword.class);
                startActivity(intent);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingChangeEmail.class);
                startActivity(intent);
            }
        });

        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingGeneral.class);
                startActivity(intent);
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingAboutUs.class);
                startActivity(intent);
            }
        });

        termsAndConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingTermsAndConditions.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            Intent home = new Intent(Setting.this,HomeActivity.class);
                            startActivity(home);
                            return true;
                        case R.id.navigation_explore:
                            Intent explore = new Intent(Setting.this,ExploreActivity.class);
                            startActivity(explore);
                            return true;
                        case R.id.navigation_history:
                            Intent history = new Intent(Setting.this, HistoryActivity.class);
                            startActivity(history);
                            return true;
                        case R.id.navigation_profile:
                            Intent profile = new Intent(Setting.this,ProfileActivity.class);
                            startActivity(profile);
                            return true;
                    }
                    return false;
                }
            };
}

