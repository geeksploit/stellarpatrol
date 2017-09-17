package com.shootan.stellarpatrol.gameobjects.bullets;

import com.badlogic.gdx.math.Vector2;
import com.shootan.stellarpatrol.gameobjects.GameObject;

/**
 * Created by geeksploit on 17.09.2017.
 */

public abstract class Bullet extends GameObject {

    public Bullet(Vector2 position, float angle) {
        super(position);
    }
}
