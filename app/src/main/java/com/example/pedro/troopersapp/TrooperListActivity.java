package com.example.pedro.troopersapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.pedro.troopersapp.adapter.TrooperAdapter;
import com.example.pedro.troopersapp.model.Trooper;
import com.example.pedro.troopersapp.repository.TrooperRepository;
import com.example.pedro.troopersapp.util.Constants;

import java.util.ArrayList;

public class TrooperListActivity extends AppCompatActivity implements View.OnLongClickListener {

    private RecyclerView rvTroopers;
    private ArrayList<Trooper> troopers;
    private TrooperAdapter trooperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trooper_list);
        rvTroopers = findViewById(R.id.troopers_rv);
        populateRecyclerView();
    }

    private void populateRecyclerView() {
        troopers = TrooperRepository.tryGettingFromSharedPreferences(getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE));

        rvTroopers.setLayoutManager(
                new LinearLayoutManager(this));

        trooperAdapter = new TrooperAdapter(troopers, this);
        rvTroopers.setAdapter(trooperAdapter);
    }

    @Override
    public boolean onLongClick(final View view) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Excluir Trooper")
                .setMessage("Tem certeza que deseja excluir este trooper?")
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int position = rvTroopers.getChildLayoutPosition(view);
                        troopers.remove(position);
                        trooperAdapter.notifyDataSetChanged();
                        Toast.makeText(TrooperListActivity.this, "Trooper excluído", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        TrooperRepository.saveToSharedPreferences(troopers,getSharedPreferences(Constants.PREFS_NAME,MODE_PRIVATE));
    }
}