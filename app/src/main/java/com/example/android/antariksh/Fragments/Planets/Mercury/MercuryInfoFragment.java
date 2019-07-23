package com.example.android.antariksh.Fragments.Planets.Mercury;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.antariksh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MercuryInfoFragment extends Fragment {


    public MercuryInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mercury_info, container, false);
    }

}
