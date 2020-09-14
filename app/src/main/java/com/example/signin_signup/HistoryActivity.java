package com.example.signin_signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.signin_signup.model.History;
import com.example.signin_signup.model.Project;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    BottomNavigationView bottomNavigation;
    private DatabaseReference HistoryRef;
    private ArrayList<History> historyList;
    private HistoryAdapter historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        recyclerView = findViewById(R.id.historyList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        HistoryRef= FirebaseDatabase.getInstance().getReference("Cart List");
        historyList=new ArrayList<>();
        GetData();
        ClearAll();

    }

    private void GetData() {
        Query query = HistoryRef.child("Book");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ClearAll();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    History history = new History();


                    history.setTitle(dataSnapshot.child("Title").getValue().toString());
                    history.setAuthor(dataSnapshot.child("Author").getValue().toString());



                    historyList.add(history);
                }
                historyAdapter = new HistoryAdapter(getApplicationContext(),historyList);
                recyclerView.setAdapter(historyAdapter);
                historyAdapter.notifyDataSetChanged();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void ClearAll() {
        if (historyList!=null){
            historyList.clear();
            if(historyAdapter!=null){
                historyAdapter.notifyDataSetChanged();
            }
        }
        historyList=new ArrayList<>();
    }



    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            Intent home = new Intent(HistoryActivity.this,HomeActivity.class);
                            startActivity(home);
                            return true;
                        case R.id.navigation_explore:
                            Intent explore = new Intent(HistoryActivity.this,ExploreActivity.class);
                            startActivity(explore);
                            return true;
                        case R.id.navigation_history:
                            Intent history = new Intent(HistoryActivity.this, HistoryActivity.class);
                            startActivity(history);
                            return true;
                        case R.id.navigation_profile:
                            Intent profile = new Intent(HistoryActivity.this,ProfileActivity.class);
                            startActivity(profile);
                            return true;
                    }
                    return false;
                }
            };

}