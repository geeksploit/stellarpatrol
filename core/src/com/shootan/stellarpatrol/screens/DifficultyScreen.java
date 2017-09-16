package com.shootan.stellarpatrol.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.shootan.stellarpatrol.StellarPatrolGame;
import com.shootan.stellarpatrol.util.Constants;

/**
 * Created by geeksploit on 16.09.2017.
 */

public class DifficultyScreen implements Screen {

    private StellarPatrolGame game;

    private Vector2 easyCenter;
    private Vector2 mediumCenter;
    private Vector2 hardCenter;

    private ExtendViewport extendViewport;
    private ShapeRenderer shapeRenderer;

    public DifficultyScreen(StellarPatrolGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        easyCenter = new Vector2();
        mediumCenter = new Vector2();
        hardCenter = new Vector2();

        extendViewport = new ExtendViewport(Constants.DIFFICULTY_WORLD_SIZE, Constants.DIFFICULTY_WORLD_SIZE);
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render(float delta) {
        extendViewport.apply();
    }

    @Override
    public void resize(int width, int height) {
        extendViewport.update(width, height, true);
        float x = extendViewport.getWorldWidth() / 4;
        float y = extendViewport.getWorldHeight() / 2;
        easyCenter.set(x, y);
        mediumCenter.set(x * 2, y);
        hardCenter.set(x * 3, y);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
