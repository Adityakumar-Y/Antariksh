package com.example.android.antariksh.Fragments.Planets;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.antariksh.Activities.PlanetActivity;
import com.example.android.antariksh.Adapters.PlanetAdapter;
import com.example.android.antariksh.Fragments.HomeFragment;
import com.example.android.antariksh.Fragments.ProfileFragment;
import com.example.android.antariksh.Models.Planet;
import com.example.android.antariksh.R;

import java.util.ArrayList;

/**
 * Created by neha on 7/7/2019.
 */

public class PlanetsInfoFragment extends Fragment {

    PlanetAdapter planetAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.planet_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView planetList = (RecyclerView) view.findViewById(R.id.planetList);
        planetList.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Planet> planet = new ArrayList<>();
        planet.add(new Planet(R.drawable.ic_launcher_background,"Mercury","Mercury Description"));
        planet.add(new Planet(R.drawable.ic_launcher_background,"Venus","Venus Description"));
        planet.add(new Planet(R.drawable.ic_launcher_background,"Earth","Earth Description"));
        planet.add(new Planet(R.drawable.ic_launcher_background,"Mars","Mars Description"));
        planet.add(new Planet(R.drawable.ic_launcher_background,"Jupiter","Jupiter Description"));
        planet.add(new Planet(R.drawable.ic_launcher_background,"Saturn","Saturn Description"));
        planet.add(new Planet(R.drawable.ic_launcher_background,"Uranus","Uranus Description"));
        planet.add(new Planet(R.drawable.ic_launcher_background,"Neptune","Neptune Description"));

        planetAdapter = new PlanetAdapter(planet);
        planetList.setAdapter(planetAdapter);

        planetAdapter.setOnItemClickListener(new PlanetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Fragment selectedPlanet = null;
                Intent intent;
                switch (position){
                    case 0:
                        Toast.makeText(getContext(), "Mercury", Toast.LENGTH_SHORT).show();
                        intent = new Intent(getActivity(), PlanetActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(getContext(), "Venus", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getContext(), "Earth", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getContext(), "Mars", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getContext(), "Planets", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    /*@Override
    public void onItemClick(int position) {

    }
    */
}
