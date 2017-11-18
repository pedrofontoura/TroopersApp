package com.example.pedro.troopersapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pedro.troopersapp.R;
import com.example.pedro.troopersapp.model.Trooper;
import com.example.pedro.troopersapp.util.ResourceUtil;

import java.util.ArrayList;

/**
 * Criado por hedo.junior em 18/11/2017.
 */

public class TrooperAdapter
        extends RecyclerView.Adapter<TrooperAdapter.ViewHolder> {

    private ArrayList<Trooper> troopers;

    public TrooperAdapter(ArrayList<Trooper> troopers) {
        this.troopers = troopers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.view_item_trooper,
                                parent,
                                false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Trooper trooper = troopers.get(position);
        holder.tvTrooperName.setText(trooper.getName());
        holder
                .imvTrooperAffiliation
                .setImageResource(ResourceUtil
                        .getResourceBasedOnAffiliation(
                                trooper.getAffiliation()
                        )
                );

        holder.separator
                .setVisibility(
                        position == troopers.size() - 1 ?
                                View.INVISIBLE : View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return troopers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTrooperName;
        ImageView imvTrooperAffiliation;
        View separator;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTrooperName = itemView.findViewById(R.id.trooper_name_tv);
            imvTrooperAffiliation =
                    itemView.findViewById(R.id.trooper_affiliation_imv);

            separator = itemView.findViewById(R.id.separator);
        }
    }
}
