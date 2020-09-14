package com.example.signin_signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.signin_signup.model.Project;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class CartActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private Button checkout;
    private TextView txtTotalAmount;
    private int overTotalPrice = 0;
    BottomNavigationView bottomNavigation;
    private DatabaseReference CartRef;
    private ArrayList<Project> bookList;
    private CartAdapter cartAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        recyclerView = findViewById(R.id.cart_list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        txtTotalAmount = (TextView) findViewById(R.id.total_price);

        CartRef = FirebaseDatabase.getInstance().getReference("Cart List");

       bookList=new ArrayList<>();
        GetData();
        ClearAll();

        checkout = (Button) findViewById(R.id.button_checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTotalAmount.setText("Total Price = " + "RM" + String.valueOf(overTotalPrice));

                Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
                intent.putExtra("Total Price", String.valueOf(overTotalPrice));
                startActivity(intent);
                finish();
            }
        });
    }


    private void GetData() {
        Query query = CartRef.child("Book");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ClearAll();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                   Project project = new Project();


                    project.setTitle(dataSnapshot.child("Title").getValue().toString());
                    project.setAuthor(dataSnapshot.child("Author").getValue().toString());



                    bookList.add(project);
                }
                cartAdapter = new CartAdapter(getApplicationContext(),bookList);
                recyclerView.setAdapter(cartAdapter);
                cartAdapter.notifyDataSetChanged();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    private void ClearAll() {
        if (bookList!=null){
            bookList.clear();
            if(cartAdapter!=null){
                cartAdapter.notifyDataSetChanged();
            }
        }
        bookList=new ArrayList<>();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            Intent home = new Intent(CartActivity.this,HomeActivity.class);
                            startActivity(home);
                            return true;
                        case R.id.navigation_explore:
                            Intent explore = new Intent(CartActivity.this,ExploreActivity.class);
                            startActivity(explore);
                            return true;
                        case R.id.navigation_history:
                            Intent history = new Intent(CartActivity.this, HistoryActivity.class);
                            startActivity(history);
                            return true;
                        case R.id.navigation_profile:
                            Intent profile = new Intent(CartActivity.this,ProfileActivity.class);
                            startActivity(profile);
                            return true;
                    }
                    return false;
                }
            };

}