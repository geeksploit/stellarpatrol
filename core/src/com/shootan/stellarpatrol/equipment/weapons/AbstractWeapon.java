package com.shootan.stellarpatrol.equipment.weapons;

import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.shootan.stellarpatrol.gameobjects.GameObject;

/**
 * Created by geeksploit on 17.09.2017.
 */

abstract class AbstractWeapon implements Weapon {

    private float reloadCooldown;
    private Class bulletClass;

    AbstractWeapon() {
    }

    @Override
    public Array<GameObject> shoot(float deltaTime, Vector2 parentPosition, float parentAngle) {
        return null;
    }

    @Override
    public void setReloadCooldown(float reloadCooldown) {
        this.reloadCooldown = reloadCooldown;
    }

    @Override
    public float getReloadCooldown() {
        return reloadCooldown;
    }

    @Override
    public void setBulletClass(Class bulletClass) {
        this.bulletClass = bulletClass;
    }

    @Override
    public Matrix3 getOriginTransformMatrix() {
        return null;
    }
}
