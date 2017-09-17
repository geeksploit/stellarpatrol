package com.shootan.stellarpatrol.gameobjects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by geeksploit on 17.09.2017.
 */

public abstract class GameObject {

    private Vector2 position;

    public GameObject(Vector2 position) {
        this.position = position;
    }
}
