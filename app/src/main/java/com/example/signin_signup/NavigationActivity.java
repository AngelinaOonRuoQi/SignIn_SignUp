package com.example.signin_signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class NavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

    }


    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                          Intent home = new Intent(NavigationActivity.this,HomeActivity.class);
                          startActivity(home);
                            return true;
                        case R.id.navigation_explore:
                            Intent explore = new Intent(NavigationActivity.this,ExploreActivity.class);
                            startActivity(explore);

                            return true;
                        case R.id.navigation_history:
                            Intent history = new Intent(NavigationActivity.this, HistoryActivity.class);
                            startActivity(history);

                            return true;
                        case R.id.navigation_profile:
                            Intent profile = new Intent(NavigationActivity.this,ProfileActivity.class);
                            startActivity(profile);
                            return true;
                    }
                    return false;
                }
            };


}