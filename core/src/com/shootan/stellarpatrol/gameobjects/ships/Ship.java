package com.shootan.stellarpatrol.gameobjects.ships;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.shootan.stellarpatrol.equipment.weapons.Weapon;
import com.shootan.stellarpatrol.gameobjects.GameObject;
import com.shootan.stellarpatrol.gameobjects.bullets.Bullet;

/**
 * Created by geeksploit on 18.09.2017.
 */

public abstract class Ship extends GameObject {

    private float hitPoints;
    private Array<Weapon> weapons;
    private Array<Bullet> bullets;

    public Ship(Vector2 position) {
        super(position);
        weapons = new Array<Weapon>();
        bullets = new Array<Bullet>();
    }

    public float getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(float hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void addWeapons(Weapon...weapons) {
        this.weapons.addAll(weapons);
    }
}
