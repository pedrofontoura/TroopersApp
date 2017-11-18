package com.example.pedro.troopersapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pedro.troopersapp.adapter.TrooperAdapter;
import com.example.pedro.troopersapp.model.Trooper;
import com.example.pedro.troopersapp.repository.TrooperRepository;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTroopers;
    private ArrayList<Trooper> troopers;
    private TrooperAdapter trooperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTroopers = findViewById(R.id.troopers_rv);
        populateRecyclerView();
    }

    private void populateRecyclerView() {
        troopers = TrooperRepository.getAll();

        rvTroopers.setLayoutManager(
                new LinearLayoutManager(this));

        trooperAdapter = new TrooperAdapter(troopers);
        rvTroopers.setAdapter(trooperAdapter);
    }
}