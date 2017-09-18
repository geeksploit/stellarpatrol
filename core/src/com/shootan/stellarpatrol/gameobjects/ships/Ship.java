package com.shootan.stellarpatrol.gameobjects.ships;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.shootan.stellarpatrol.equipment.weapons.Weapon;
import com.shootan.stellarpatrol.gameobjects.GameObject;

/**
 * Created by geeksploit on 18.09.2017.
 */

public abstract class Ship extends GameObject {

    private float hitPoints;
    private Array<Weapon> weapons;

    public Ship(Vector2 position) {
        super(position);
        weapons = new Array<Weapon>();
    }

    public float getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(float hitPoints) {
        this.hitPoints = hitPoints;
    }
}
