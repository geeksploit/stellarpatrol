package com.shootan.stellarpatrol.gameobjects;

import com.badlogic.gdx.utils.DelayedRemovalArray;

/**
 * Created by geeksploit on 18.09.2017.
 */

public final class GameObjectsContainer {

    private DelayedRemovalArray<GameObject> gameObjects;

    public GameObjectsContainer() {
        gameObjects = new DelayedRemovalArray<GameObject>();
    }
}
