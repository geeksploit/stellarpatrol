package com.shootan.stellarpatrol.gameobjects.ships;

/**
 * Created by geeksploit on 20.09.2017.
 */

public final class ShipFactory {

    private static ShipFactory instance;

    private ShipFactory() {}

    public static ShipFactory getInstance() {
        if (instance == null) {
            instance = new ShipFactory();
        }
        return instance;
    }
}
