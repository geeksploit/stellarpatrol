package com.shootan.stellarpatrol.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.shootan.stellarpatrol.gameobjects.ships.Player;

/**
 * Created by geeksploit on 18.09.2017.
 */

public final class GameObjectsContainer {

    private DelayedRemovalArray<GameObject> gameObjects;
    private Player player;

    public GameObjectsContainer() {
        gameObjects = new DelayedRemovalArray<GameObject>();
        this.player = new Player(new Vector2());
        gameObjects.add(player);
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

    public Vector2 preparePlayerDestination(float x, float y) {
        player.setDestination(x, y);
        return player.getDestination();
    }
}
