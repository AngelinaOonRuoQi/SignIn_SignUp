package com.example.signin_signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.signin_signup.model.Project;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;


public class BookDetailsActivity extends AppCompatActivity {
    private Button borrow, chooseDate;
    private ImageView productImage;
    private TextView productName, productAuthor, productSummary;
    private String title = "";
    private DatabaseReference ProductRef;
    BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        ProductRef = FirebaseDatabase.getInstance().getReference().child("Project");

        title = getIntent().getStringExtra("Title");

        productImage = (ImageView) findViewById(R.id.product_image);
        productName = (TextView) findViewById(R.id.product_name);
        productAuthor = (TextView) findViewById(R.id.product_author);
        productSummary = (TextView) findViewById(R.id.product_summary);
        borrow=(Button) findViewById(R.id.btn_borrow);
        chooseDate=(Button) findViewById(R.id.btn_date);

        getBookDetails(title);


        borrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               borrowBook();
            }
        });
        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookDetailsActivity.this, BorrowBookActivity.class);
                startActivity(intent);
            }
        });


    }

    private void borrowBook() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Cart List");
        final HashMap<String,Object> map = new HashMap<>();
        map.put("Title",title);
        map.put("Author",productAuthor.getText().toString());


        ref.child("Book")
                .child("Title")
                .updateChildren(map)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(BookDetailsActivity.this,"Added",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(BookDetailsActivity.this,CartActivity.class);
                            intent.putExtra("Title",title);
                            startActivity(intent);
                        }
                    }
                });
    }

    private void getBookDetails(String title) {
        ProductRef = FirebaseDatabase.getInstance().getReference().child("Project");

        ProductRef.child(title).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    Project project = snapshot.getValue(Project.class);
                    productName.setText(project.getTitle());
                    productAuthor.setText(project.getAuthor());
                    productSummary.setText(project.getSummary());
                    Picasso.get().load(project.getImage()).into(productImage);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            Intent home = new Intent(BookDetailsActivity.this,HomeActivity.class);
                            startActivity(home);
                            return true;
                        case R.id.navigation_explore:
                            Intent explore = new Intent(BookDetailsActivity.this,ExploreActivity.class);
                            startActivity(explore);
                            return true;
                        case R.id.navigation_history:
                            Intent history = new Intent(BookDetailsActivity.this, HistoryActivity.class);
                            startActivity(history);
                            return true;
                        case R.id.navigation_profile:
                            Intent profile = new Intent(BookDetailsActivity.this,ProfileActivity.class);
                            startActivity(profile);
                            return true;
                    }
                    return false;
                }
            };

}