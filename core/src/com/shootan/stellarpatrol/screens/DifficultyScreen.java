package com.shootan.stellarpatrol.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
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
    private SpriteBatch spriteBatch;

    private Texture background;
    private BitmapFont bitmapFont;

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
        spriteBatch = new SpriteBatch();

        background = Constants.BACKGROUND.random();
        bitmapFont = new BitmapFont();
        bitmapFont.getData().setScale(Constants.DIFFICULTY_LABEL_SCALE);
        bitmapFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    @Override
    public void render(float delta) {
        extendViewport.apply();

        spriteBatch.setProjectionMatrix(extendViewport.getCamera().combined);
        spriteBatch.begin();
        {
            spriteBatch.draw(background, 0, 0, extendViewport.getWorldWidth(), extendViewport.getWorldHeight());
        }
        spriteBatch.end();

        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        shapeRenderer.setProjectionMatrix(extendViewport.getCamera().combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        {
            shapeRenderer.setColor(Constants.EASY_COLOR);
            shapeRenderer.circle(easyCenter.x, easyCenter.y, Constants.DIFFICULTY_BUBBLE_RADIUS);
            shapeRenderer.setColor(Constants.MEDIUM_COLOR);
            shapeRenderer.circle(mediumCenter.x, mediumCenter.y, Constants.DIFFICULTY_BUBBLE_RADIUS);
            shapeRenderer.setColor(Constants.HARD_COLOR);
            shapeRenderer.circle(hardCenter.x, hardCenter.y, Constants.DIFFICULTY_BUBBLE_RADIUS);
        }
        shapeRenderer.end();

        spriteBatch.begin();
        {
            float halfCapHeight = bitmapFont.getCapHeight() / 2;
            bitmapFont.draw(spriteBatch, Constants.EASY_LABEL,
                    easyCenter.x, easyCenter.y + halfCapHeight,
                    0, Align.center, false);
            bitmapFont.draw(spriteBatch, Constants.MEDIUM_LABEL,
                    mediumCenter.x, mediumCenter.y + halfCapHeight,
                    0, Align.center, false);
            bitmapFont.draw(spriteBatch, Constants.HARD_LABEL,
                    hardCenter.x, hardCenter.y + halfCapHeight,
                    0, Align.center, false);
        }
        spriteBatch.end();
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
