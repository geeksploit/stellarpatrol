package com.shootan.stellarpatrol.gameobjects.ships;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.shootan.stellarpatrol.equipment.weapons.Weapon;
import com.shootan.stellarpatrol.gameobjects.GameObject;
import com.shootan.stellarpatrol.gameobjects.bullets.Bullet;

/**
 * Created by geeksploit on 18.09.2017.
 */

public abstract class Ship extends GameObject {

    private Vector2 course = new Vector2();
    private Vector2 destination = new Vector2();

    private float hitPoints;
    private Array<Weapon> weapons;
    private Array<Bullet> bullets;

    public Ship(Vector2 position) {
        super(position);
        weapons = new Array<Weapon>();
        bullets = new Array<Bullet>();
    }

    public Vector2 getCourse() {
        return course;
    }

    public void setCourse(Vector2 course) {
        this.course = course;
    }

    public Vector2 getDestination() {
        return destination;
    }

    public void setDestination(Vector2 destination) {
        this.destination = destination;
    }

    public float getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(float hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void addWeapons(Weapon...weapons) {
        this.weapons.addAll(weapons);
    }

    public Array<Bullet> shootWeapons(float deltaTime) {
        bullets.clear();
        for (int i = 0; i < weapons.size; i++) {
            bullets.addAll(weapons.get(i).shoot(deltaTime, getPosition(), getRotation()));
        }
        for (int i = 0; i < bullets.size; i++) {
            Bullet b = bullets.get(i);
            b.getVelocity().mulAdd(getVelocity(), .75f);
        }
        return bullets;
    }
}
