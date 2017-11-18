package com.example.pedro.troopersapp.util;

import com.example.pedro.troopersapp.R;
import com.example.pedro.troopersapp.model.Affiliation;

/**
 * Created by Pedro on 18/11/2017.
 */

public class ResourceUtil {

    public static int getResourceBasedOnAffiliation(Affiliation affiliation) {
        switch (affiliation) {
            case GALACTIC_REPUBLIC:
                return R.drawable.galactic_republic;
            case GALACTIC_EMPIRE:
                return R.drawable.galactic_empire;
            case FIRST_ORDER:
                return R.drawable.first_order;
        }
        return 0;
    }
}
