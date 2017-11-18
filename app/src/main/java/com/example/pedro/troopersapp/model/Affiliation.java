package com.example.pedro.troopersapp.model;

/**
 * Created by Pedro on 18/11/2017.
 */

public enum Affiliation {
    GALACTIC_REPUBLIC(0),
    GALACTIC_EMPIRE(1),
    FIRST_ORDER(2);

    Affiliation(int value) {
        this.value = value;
    }

    private int value;
}
