package com.example.android.antariksh.Fragments.Planets;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.antariksh.R;

public class PlanetMain extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_planets, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getContext(), "Hello", Toast.LENGTH_SHORT).show();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.bottom_navigation);
        getFragmentManager().beginTransaction().replace(R.id.planet_fragment, new PlanetsInfoFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.nav_info:
                        fragment = new PlanetsInfoFragment();
                        break;
                    case R.id.nav_news:
                        fragment = new PlanetsNewsFragment();
                        break;
                    case R.id.nav_quiz:
                        fragment = new PlanetsQuizFragment();
                        break;
                }
                getFragmentManager().beginTransaction().replace(R.id.planet_fragment, fragment).commit();
                return true;
            }
        });
    }
}
