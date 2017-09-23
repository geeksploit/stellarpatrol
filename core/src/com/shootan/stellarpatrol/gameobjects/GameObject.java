package com.shootan.stellarpatrol.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

/**
 * Created by geeksploit on 17.09.2017.
 */

public abstract class GameObject implements Pool.Poolable {

    private Vector2 acceleration;
    private Vector2 velocity;
    private Vector2 position;
    private float rotation;

    private float scaleX;
    private float scaleY;
    private TextureRegion textureRegion;

    public GameObject(Vector2 position) {
        this.acceleration = new Vector2();
        this.velocity = new Vector2();
        this.position = position;
        setScale(1);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void setScale(float scale) {
        setScale(scale, scale);
    }

    public void setScale(float scaleX, float scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public void update(float deltaTime) {
        getVelocity().mulAdd(getAcceleration(), deltaTime);
        getPosition().mulAdd(getVelocity(), deltaTime);
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(textureRegion, position.x - .5f, position.y - .5f, .5f, .5f, 1, 1,
                getAspectRatio() * scaleX, scaleY, getTextureRotation());
    }

    private float getAspectRatio() {
        return (float) textureRegion.getRegionWidth() / textureRegion.getRegionHeight();
    }

    private float getTextureRotation() {
        return rotation - 90;
    }

    @Override
    public void reset() {
        getVelocity().set(Vector2.Zero);
        getAcceleration().set(Vector2.Zero);
        getPosition().set(Vector2.Zero);
        setTextureRegion(null);
        setRotation(0);
        setScale(1);
    }
}
