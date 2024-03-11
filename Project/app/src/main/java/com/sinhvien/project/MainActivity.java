package com.sinhvien.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                int id = item.getItemId();
                if(id==R.id.home){
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                }
                else if (id==R.id.booking) {
                    fragment = new BookingFragment();
                    loadFragment(fragment);
                    return true;
                }
                else if (id==R.id.setting) {
                    fragment = new SettingsFragment();
                    loadFragment(fragment);
                    return true;
                }
                else if (id==R.id.profile) {
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
                }
                else
                    return false;
            }
        });
        Fragment initialFragment = new HomeFragment();
        loadFragment(initialFragment);
    }
    private void loadFragment(Fragment fragment) {
        // Load Fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}