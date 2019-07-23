package com.example.android.antariksh.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.antariksh.Fragments.HomeFragment;
import com.example.android.antariksh.Fragments.Missions.MissionsFragment;
import com.example.android.antariksh.Fragments.Planets.PlanetMain;
import com.example.android.antariksh.Fragments.ProfileFragment;
import com.example.android.antariksh.Fragments.Stars.StarsFragment;
import com.example.android.antariksh.R;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolBar(); // Details about toolbar setup and drawer toggle

        setUpNavigationItemSelector(savedInstanceState); // Actions to be performed when navigation item gets selected

    }



    private void setUpNavigationItemSelector(Bundle savedInstanceState) {

        NavigationView navigationView = findViewById(R.id.nav_view);
        // Intially load the fragment with Home Page
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
        // Load appropriate Fragment based on the item selected
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                        getSupportActionBar().setTitle("Home");
                        break;
                    case R.id.nav_planets:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PlanetMain()).commit();
                        getSupportActionBar().setTitle("Planets");
                        break;
                    case R.id.nav_stars:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new StarsFragment()).commit();
                        getSupportActionBar().setTitle("Stars");
                        break;
                    case R.id.nav_missions:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MissionsFragment()).commit();
                        getSupportActionBar().setTitle("Missions");
                        break;
                    case R.id.nav_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
                        getSupportActionBar().setTitle("Profile");
                        break;
                    case R.id.nav_aboutus:
                        Toast.makeText(MainActivity.this, "About Us", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_share:
                        Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void setUpToolBar() {

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
