package com.shootan.stellarpatrol.gameobjects.ships;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.shootan.stellarpatrol.equipment.weapons.PrimaryWeapon;
import com.shootan.stellarpatrol.equipment.weapons.Weapon;
import com.shootan.stellarpatrol.util.Constants;

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

    public Array<Ship> makeShip() {
        ships.clear();
        float random = MathUtils.random() * 10;

        if (random < .05f) {
            Enemy ship;
            ship = new Enemy(new Vector2(
                    MathUtils.random(0, Constants.WORLD_SIZE),
                    Constants.WORLD_SIZE));
            ship.getDestination().set(
                    MathUtils.random(0, Constants.WORLD_SIZE),
                    MathUtils.random(0, Constants.WORLD_SIZE));
            ship.setTextureRegion(Constants.SHIP_TEXTURE_REGIONS.get(1));
            ships.add(ship);
        } else if (random < .075f) {
            Enemy ship;
            ship = new Enemy(new Vector2(
                    MathUtils.random(0, Constants.WORLD_SIZE),
                    Constants.WORLD_SIZE));
            ship.getDestination().set(
                    MathUtils.random(0, Constants.WORLD_SIZE),
                    MathUtils.random(0, Constants.WORLD_SIZE));
            ship.setTextureRegion(Constants.SHIP_TEXTURE_REGIONS.get(2));
            ships.add(ship);
        } else if (random < .09f) {
            Enemy ship;
            ship = new Enemy(new Vector2(
                    MathUtils.random(0, Constants.WORLD_SIZE),
                    Constants.WORLD_SIZE));
            ship.getDestination().set(
                    MathUtils.random(0, Constants.WORLD_SIZE),
                    MathUtils.random(0, Constants.WORLD_SIZE));
            ship.setTextureRegion(Constants.SHIP_TEXTURE_REGIONS.get(3));

            Weapon w1 = new PrimaryWeapon(Constants.PLAYER_WEAPON_COOLDOWN / 2);
            w1.getOriginTransformMatrix().translate(.5f, 0);
            ship.addWeapons(w1);

            ships.add(ship);
        } else if (random < .1f) {
            Enemy ship;
            ship = new Enemy(new Vector2(
                    MathUtils.random(0, Constants.WORLD_SIZE),
                    Constants.WORLD_SIZE));
            ship.getDestination().set(
                    MathUtils.random(0, Constants.WORLD_SIZE),
                    MathUtils.random(0, Constants.WORLD_SIZE));
            ship.setTextureRegion(Constants.SHIP_TEXTURE_REGIONS.get(4));

            Weapon w1 = new PrimaryWeapon(Constants.PLAYER_WEAPON_COOLDOWN / 2);
            w1.getOriginTransformMatrix().rotate(40);
            w1.getOriginTransformMatrix().translate(.5f, 0);
            w1.getOriginTransformMatrix().rotate(-41);

            Weapon w2 = new PrimaryWeapon(Constants.PLAYER_WEAPON_COOLDOWN / 2);
            w2.getOriginTransformMatrix().rotate(-40);
            w2.getOriginTransformMatrix().translate(.5f, 0);
            w2.getOriginTransformMatrix().rotate(41);

            ship.addWeapons(w1, w2);

            ships.add(ship);
        }

        return ships;
    }
}
