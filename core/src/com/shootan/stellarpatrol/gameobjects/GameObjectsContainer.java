package com.shootan.stellarpatrol.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.shootan.stellarpatrol.gameobjects.bullets.Bullet;
import com.shootan.stellarpatrol.gameobjects.ships.Player;
import com.shootan.stellarpatrol.gameobjects.ships.Ship;
import com.shootan.stellarpatrol.gameobjects.ships.ShipFactory;

/**
 * Created by geeksploit on 18.09.2017.
 */

public final class GameObjectsContainer {

    private DelayedRemovalArray<GameObject> gameObjects;
    private Array<Bullet> bullets;
    private Player player;

    public GameObjectsContainer() {
        gameObjects = new DelayedRemovalArray<GameObject>();
        bullets = new Array<Bullet>();
        this.player = new Player(new Vector2());
        gameObjects.add(player);
    }

    public void update (float deltaTime) {
        gameObjects.begin();

        for (int i = 0; i < gameObjects.size; i++) {
            gameObjects.get(i).update(deltaTime);
        }

        for (int i = 0; i < gameObjects.size; i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject instanceof Ship) {
                Ship ship = (Ship) gameObject;
                gameObjects.addAll(ship.shootWeapons(deltaTime));
            }
        }

        bullets.clear();
        for (int i = 0; i < gameObjects.size; i++) {
            if (gameObjects.get(i) instanceof  Bullet) {
                bullets.add((Bullet) gameObjects.get(i));
            }
        }

        for (int i = 0; i < bullets.size; i++) {
            Bullet bullet = bullets.get(i);

            for (int j = 0; j < gameObjects.size; j++) {
                GameObject gameObject = gameObjects.get(j);

                if (gameObject instanceof Bullet) {
                    continue;
                }
            }
        }

        gameObjects.addAll(ShipFactory.getInstance().makeShip());

        gameObjects.removeValue(player, true);
        gameObjects.add(player);

        gameObjects.end();
    }

    public void draw (SpriteBatch spriteBatch) {
        for (int i = 0; i < gameObjects.size; i++) {
            gameObjects.get(i).draw(spriteBatch);
        }
    }

    public Vector2 preparePlayerDestination(float x, float y) {
        return player.getDestination().set(x, y);
    }

    public Vector2 getPlayerPosition() {
        return player.getPosition();
    }
}
