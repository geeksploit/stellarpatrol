package com.shootan.stellarpatrol.gameobjects.ships;

import com.badlogic.gdx.math.Vector2;
import com.shootan.stellarpatrol.equipment.weapons.PrimaryWeapon;
import com.shootan.stellarpatrol.equipment.weapons.Weapon;
import com.shootan.stellarpatrol.util.Constants;

/**
 * Created by geeksploit on 18.09.2017.
 */

public final class Player extends Ship {

    private Vector2 destination = new Vector2();
    private Vector2 course = new Vector2();

    public Player(Vector2 position) {
        super(position);
        setTextureRegion(Constants.SHIP_TEXTURE_REGIONS.get(0));
        setScale(1);
        setRotation(90);

        Weapon w1 = new PrimaryWeapon(Constants.PLAYER_WEAPON_COOLDOWN / 2);
        w1.getOriginTransformMatrix().translate(.5f, 0);

        addWeapons(w1);
        setHitPoints(Constants.PLAYER_STARTING_HITPOINTS);
    }

    public Vector2 getDestination() {
        return destination;
    }

    public void setDestination(float x, float y) {
        this.destination.set(x, y);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        course.set(getDestination().cpy().sub(getPosition()));
        if (course.epsilonEquals(Vector2.Zero, Constants.WORLD_SIZE / 128)) {
            getVelocity().set(Vector2.Zero);
        } else {
            getVelocity().set(course.scl(3));
        }
    }
}
