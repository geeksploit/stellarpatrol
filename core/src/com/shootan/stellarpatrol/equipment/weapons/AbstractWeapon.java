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
    private Matrix3 originTransformMatrix;

    private float reloadCooldownTimeout;

    AbstractWeapon() {
    }

    @Override
    public Array<GameObject> shoot(float deltaTime, Vector2 parentPosition, float parentAngle) {
        Array<GameObject> bullets = new Array<GameObject>();
        return bullets;
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
        return originTransformMatrix;
    }

    private boolean isReadyToShoot(float deltaTime) {
        reloadCooldownTimeout -= deltaTime;
        if (reloadCooldownTimeout < 0) {
            reloadCooldownTimeout = reloadCooldown;
            return true;
        }
        return false;
    }
}
