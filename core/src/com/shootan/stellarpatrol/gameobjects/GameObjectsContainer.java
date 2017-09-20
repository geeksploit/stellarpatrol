package com.shootan.stellarpatrol.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.shootan.stellarpatrol.gameobjects.ships.Player;

/**
 * Created by geeksploit on 18.09.2017.
 */

public final class GameObjectsContainer {

    private DelayedRemovalArray<GameObject> gameObjects;
    Player player;

    public GameObjectsContainer() {
        gameObjects = new DelayedRemovalArray<GameObject>();
    }

    public void update (float deltaTime) {
        for (int i = 0; i < gameObjects.size; i++) {
            gameObjects.get(i).update(deltaTime);
        }
    }

    public void draw (SpriteBatch spriteBatch) {
        for (int i = 0; i < gameObjects.size; i++) {
            gameObjects.get(i).draw(spriteBatch);
        }
    }
}
