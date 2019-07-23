    package com.example.android.antariksh.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.antariksh.Models.Planet;
import com.example.android.antariksh.R;

import java.util.ArrayList;

/**
 * Created by neha on 7/7/2019.
 */

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>{

    ArrayList<Planet> planets;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }


    public PlanetAdapter(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_planet_info, parent, false);
        return new PlanetViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        holder.planetImage.setBackgroundResource(planets.get(position).getImageResourceId());
        holder.planetTitle.setText(planets.get(position).getTitle());
        holder.planetDescription.setText(planets.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public static class PlanetViewHolder extends RecyclerView.ViewHolder{
        ImageView planetImage;
        TextView planetTitle,planetDescription;
        public PlanetViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            planetImage = itemView.findViewById(R.id.planet_image);
            planetTitle = itemView.findViewById(R.id.planet_title);
            planetDescription = itemView.findViewById(R.id.planet_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
