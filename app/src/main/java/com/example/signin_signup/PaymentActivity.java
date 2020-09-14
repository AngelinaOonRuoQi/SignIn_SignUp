package com.example.signin_signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.signin_signup.model.Payment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;


public class PaymentActivity extends AppCompatActivity {

    EditText txtName,txtEmail,txtContact,txtCardNumber,txtValidDate,txtCVC;
    Button process,cancel;
    BottomNavigationView bottomNavigation;
    DatabaseReference ref;
    Payment payment;
    private final String TAG = "PaymentActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        txtName=(EditText) findViewById(R.id.editTextName);
        txtEmail=(EditText) findViewById(R.id.editTextEmailAddress);
        txtContact=(EditText) findViewById(R.id.editTextPhone);
        txtCardNumber=(EditText) findViewById(R.id.editTextCardNumber);
        txtValidDate=(EditText) findViewById(R.id.editTextValidDate);
        txtCVC=(EditText) findViewById(R.id.editTextNumber2);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        payment = new Payment();
        ref= FirebaseDatabase.getInstance().getReference().child("Payment");

        process=(Button) findViewById(R.id.button_process);
        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long Tel=Long.parseLong(txtContact.getText().toString().trim());
                 Long CardNo=Long.parseLong(txtCardNumber.getText().toString().trim());

                 payment.setName(txtName.getText().toString().trim());
                 payment.setEmail(txtEmail.getText().toString().trim());
                 payment.setTel(Tel);
                payment.setCardNo(CardNo);
                payment.setCardValidDate(txtValidDate.getText().toString().trim());
                payment.setCardCVC(txtCVC.getText().toString().trim());

                ref.child("payment1").setValue(payment);
                Toast.makeText(PaymentActivity.this, "Successful Payment", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PaymentActivity.this,ProcessActivity.class);
                startActivity(intent);

            }
        });
        cancel=(Button)findViewById(R.id.button_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this,ExploreActivity.class);
                startActivity(intent);
            }
        });

        KeyboardVisibilityEvent.setEventListener(
                this,
                new KeyboardVisibilityEventListener() {
                    @Override
                    public void onVisibilityChanged(boolean isOpen) {
                        Log.d(TAG,"onVisibilityChanged: Keyboard visibility changed");
                        if(isOpen){
                            Log.d(TAG, "onVisibilityChanged: Keyboard is open");
                            bottomNavigation.setVisibility(View.INVISIBLE);
                            Log.d(TAG, "onVisibilityChanged: NavBar got Invisible");
                        }else{
                            Log.d(TAG, "onVisibilityChanged: Keyboard is closed");
                            bottomNavigation.setVisibility(View.VISIBLE);
                            Log.d(TAG, "onVisibilityChanged: NavBar got Visible");
                        }
                    }
                });
    }
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            Intent home = new Intent(PaymentActivity.this,HomeActivity.class);
                            startActivity(home);
                            return true;
                        case R.id.navigation_explore:
                            Intent explore = new Intent(PaymentActivity.this,ExploreActivity.class);
                            startActivity(explore);
                            return true;
                        case R.id.navigation_history:
                            Intent history = new Intent(PaymentActivity.this, HistoryActivity.class);
                            startActivity(history);
                            return true;
                        case R.id.navigation_profile:
                            Intent profile = new Intent(PaymentActivity.this,ProfileActivity.class);
                            startActivity(profile);
                            return true;
                    }
                    return false;
                }
            };
}