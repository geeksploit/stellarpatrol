package com.shootan.stellarpatrol.gameobjects.ships;

import com.badlogic.gdx.utils.Array;

/**
 * Created by geeksploit on 20.09.2017.
 */

public final class ShipFactory {

    private static ShipFactory instance;
    private Array<Ship> ships;

    private ShipFactory() {
        ships = new Array<Ship>();
    }

    public static ShipFactory getInstance() {
        if (instance == null) {
            instance = new ShipFactory();
        }
        return instance;
    }
}
