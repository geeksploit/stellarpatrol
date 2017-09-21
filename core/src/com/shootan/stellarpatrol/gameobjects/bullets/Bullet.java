package com.shootan.stellarpatrol.gameobjects.bullets;

import com.badlogic.gdx.math.Vector2;
import com.shootan.stellarpatrol.gameobjects.GameObject;
import com.shootan.stellarpatrol.gameobjects.ships.Ship;
import com.shootan.stellarpatrol.util.Constants;

/**
 * Created by geeksploit on 17.09.2017.
 */

public abstract class Bullet extends GameObject {

    private Ship parent;

    public Bullet(Vector2 position, float angle) {
        super(position);
        setAcceleration(new Vector2());
        setVelocity(new Vector2(0, 5));
        getVelocity().setAngle(angle);
        setScale(.4f);
    }

    @Override
    public void setVelocity(Vector2 velocity) {
        super.setVelocity(velocity.clamp(0, Constants.BULLET_MAX_VELOCITY));
    }

    public void setParent(Ship parent) {
        this.parent = parent;
    }

    public Ship getParent() {
        return parent;
    }
}
