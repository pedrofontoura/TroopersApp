package com.example.pedro.troopersapp.repository;

import android.content.SharedPreferences;

import com.example.pedro.troopersapp.model.Affiliation;
import com.example.pedro.troopersapp.model.Trooper;
import com.example.pedro.troopersapp.util.Constants;
import com.example.pedro.troopersapp.util.SharedPreferencesUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Created by Pedro on 18/11/2017.
 */

public class TrooperRepository {

    private static final ArrayList<Trooper> TROOPERS = new ArrayList<Trooper>(Arrays.asList(
            new Trooper(1, "Spacetrooper", "https://vignette.wikia.nocookie.net/starwars/images/c/ca/Spacetrooper_fullbody.png/revision/latest/scale-to-width-down/140", "Spacetroopers were stormtroopers equipped to operate in Zero-G environments. They wore a variant of the stormtrooper armor fitted with a rebreather pack.", Affiliation.GALACTIC_EMPIRE),
            new Trooper(2, "Stormtrooper", "https://vignette.wikia.nocookie.net/starwars/images/c/ca/Anovos_Stormtrooper.png/revision/latest/scale-to-width-down/140", "Stormtroopers were the assault/policing troops of the Galactic Empire. Dissenting citizens referred to them as bucketheads, a derogatory nickname inspired by the bucket-shaped helmets of stormtroopers.", Affiliation.GALACTIC_EMPIRE),
            new Trooper(3, "Clone Shadow Trooper", "https://vignette.wikia.nocookie.net/starwars/images/3/37/Utapaushadowtrooper.jpg/revision/latest/scale-to-width-down/140", "Clone shadow troopers were an elite cadre of clone troopers, devised by Director Armand Isard of Republic Intelligence during the Clone Wars. Using magseals installed in their armor, shadow troopers could attach plates to themselves that could pass them off as mercenaries belonging to certain factions.", Affiliation.GALACTIC_REPUBLIC),
            new Trooper(4, "Deathtrooper", "https://vignette.wikia.nocookie.net/starwars/images/6/69/Death_trooper_Fathead.png/revision/latest/scale-to-width-down/140", "Death troopers were an elite variant of the Galactic Empire's stormtroopers. They served as protective details and bodyguards for important Imperial officers and members of the Tarkin Initiative.", Affiliation.GALACTIC_EMPIRE),
            new Trooper(5, "Imperial Shock Trooper", "https://vignette.wikia.nocookie.net/starwars/images/9/9c/StormShock.png/revision/latest/scale-to-width-down/140", "Shock troopers were the elite members of the Imperial Stormtrooper Corps, specialized in the use of various non-standard weapons and equipment. They were also distinguishable from standard stormtroopers by their extra heavy plate armor.", Affiliation.GALACTIC_EMPIRE),
            new Trooper(6, "Jumptrooper", "https://vignette.wikia.nocookie.net/starwars/images/a/a0/Star-wars-jumptrooper-sixth-scale-hot-toys-silo-902768.png/revision/latest/scale-to-width-down/140", "Jumptroopers were a variant of the Galactic Empire's stormtroopers; similar to their clone predecessors, they were equipped with a jetpack, or alternatively, with a jump pack that could suspend them in the air or maneuver through space environments.", Affiliation.GALACTIC_EMPIRE),
            new Trooper(7, "Purgetrooper", "https://vignette.wikia.nocookie.net/starwars/images/4/4c/Bragh.png/revision/latest/scale-to-width-down/140", "Purge Troopers were a feared group of elite Imperial stormtroopers who enforced the Empire's rule in the Anoat sector on behalf of Governor Adelhard.", Affiliation.GALACTIC_EMPIRE),
            new Trooper(8, "Shadowtrooper", "https://vignette.wikia.nocookie.net/stormtrooper/images/9/99/902298-product-silo.png/revision/latest/scale-to-width-down/140", "The shadow stormtroopers, also known as Blackhole stormtroopers due to their association with Agent Blackhole, were specialized Imperial stormtroopers.", Affiliation.GALACTIC_EMPIRE),
            new Trooper(9, "Captain Phasma", "https://vignette4.wikia.nocookie.net/star-wars-canon/images/d/da/Captain-phasma-star-wars-ep7-the-force-awakens-characters-cut-out-with-transparent-background_30.png/revision/latest/scale-to-width-down/140", "Phasma was a human female stormtrooper Captain of the First Order. She served as part of the unofficial commanding triumvirate for the First Order and their Starkiller Base operation, taking charge of the command of the First Order's stormtrooper soldiers.", Affiliation.FIRST_ORDER)));

    public static ArrayList<Trooper> getAll() {
        return TROOPERS;
    }

    public static ArrayList<Trooper> tryGettingFromSharedPreferences(SharedPreferences sharedPreferences) {
        SharedPreferencesUtil util = new SharedPreferencesUtil(sharedPreferences);
        Gson gson = new Gson();
        if (util.hasValue(Constants.TROOPER_LIST)) {
            String json = util.get(Constants.TROOPER_LIST);
            return gson.fromJson(json, new TypeToken<ArrayList<Trooper>>() {
            }.getType());
        }
        return getAll();
    }

    public static void saveToSharedPreferences(ArrayList<Trooper> troopers, SharedPreferences sharedPreferences) {
        Gson gson = new Gson();
        SharedPreferencesUtil util = new SharedPreferencesUtil(sharedPreferences);
        String jsonList = gson.toJson(troopers);
        util.save(Constants.TROOPER_LIST, jsonList);
    }
}
