package com.shootan.stellarpatrol.equipment.weapons;

import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.shootan.stellarpatrol.gameobjects.GameObject;

/**
 * Created by geeksploit on 17.09.2017.
 */

abstract class AbstractWeapon implements Weapon {

    AbstractWeapon() {
    }

    @Override
    public Array<GameObject> shoot(float deltaTime, Vector2 parentPosition, float parentAngle) {
        return null;
    }

    @Override
    public void setReloadCooldown(float reloadCooldown) {

    }

    @Override
    public float getReloadCooldown() {
        return 0;
    }

    @Override
    public void setBulletClass(Class bulletClass) {

    }

    @Override
    public Matrix3 getOriginTransformMatrix() {
        return null;
    }
}
