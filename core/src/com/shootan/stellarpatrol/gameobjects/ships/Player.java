package com.shootan.stellarpatrol.gameobjects.ships;

import com.badlogic.gdx.math.Vector2;
import com.shootan.stellarpatrol.equipment.weapons.PrimaryWeapon;
import com.shootan.stellarpatrol.equipment.weapons.Weapon;
import com.shootan.stellarpatrol.util.Constants;

/**
 * Created by geeksploit on 18.09.2017.
 */

public final class Player extends Ship {

    public Player(Vector2 position) {
        super(position);
        setTextureRegion(Constants.SHIP_TEXTURE_REGIONS.get(0));
        setScale(1);
        setRotation(90);

        Weapon w1 = new PrimaryWeapon(Constants.PLAYER_WEAPON_COOLDOWN / 2);
        w1.getOriginTransformMatrix().rotate(40);
        w1.getOriginTransformMatrix().translate(.5f, 0);
        w1.getOriginTransformMatrix().rotate(-41);

        Weapon w2 = new PrimaryWeapon(Constants.PLAYER_WEAPON_COOLDOWN / 2);
        w2.getOriginTransformMatrix().rotate(-40);
        w2.getOriginTransformMatrix().translate(.5f, 0);
        w2.getOriginTransformMatrix().rotate(41);

        addWeapons(w1, w2);
        setHitPoints(Constants.PLAYER_STARTING_HITPOINTS);
    }
}
