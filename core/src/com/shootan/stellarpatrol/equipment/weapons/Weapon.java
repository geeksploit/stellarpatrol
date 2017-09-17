package com.shootan.stellarpatrol.equipment.weapons;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.shootan.stellarpatrol.gameobjects.GameObject;

/**
 * Created by geeksploit on 17.09.2017.
 */

public interface Weapon {

    Array<GameObject> shoot(float deltaTime, Vector2 parentPosition, float parentAngle);

    void setReloadCooldown(float reloadCooldown);

    float getReloadCooldown();

    void setBulletClass(Class bulletClass);
}
