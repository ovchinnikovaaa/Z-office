package com.example.zoffice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PersonnelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnel);

        /* Bottom Navigation View */

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set Accounting Selected
        //bottomNavigationView.setSelectedItemId(R.id.action_personnel);

        // Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_chat:
                        startActivity(new Intent(getApplicationContext(), ChatActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_alerts:
                        startActivity(new Intent(getApplicationContext(), AlertsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_information:
                        startActivity(new Intent(getApplicationContext(), InformationActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_settings:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_support:
                        startActivity(new Intent(getApplicationContext(), SupportActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    public void onChatClick(View view) {
        Intent intent = new Intent(PersonnelActivity.this, ChatActivity.class);
        startActivity(intent);
    }

    public void onAlertsClick(View view) {
        Intent intent = new Intent(PersonnelActivity.this, AlertsActivity.class);
        startActivity(intent);
    }

    public void onInformationClick(View view) {
        Intent intent = new Intent(PersonnelActivity.this, InformationActivity.class);
        startActivity(intent);
    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(PersonnelActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onSupportClick(View view) {
        Intent intent = new Intent(PersonnelActivity.this, SupportActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_sign_out) {
            AuthUI.getInstance().signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(PersonnelActivity.this,
                                    "You have been signed out.",
                                    Toast.LENGTH_LONG)
                                    .show();

                            // Close activity
                            finish();
                        }
                    });
        }
        return true;
    }
}