package com.shootan.stellarpatrol.gameobjects.ships;

import com.badlogic.gdx.math.Vector2;
import com.shootan.stellarpatrol.gameobjects.GameObject;

/**
 * Created by geeksploit on 18.09.2017.
 */

public abstract class Ship extends GameObject {

    private float hitPoints;

    public Ship(Vector2 position) {
        super(position);
    }

    public float getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(float hitPoints) {
        this.hitPoints = hitPoints;
    }
}
