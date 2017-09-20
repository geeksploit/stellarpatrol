package com.shootan.stellarpatrol.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.shootan.stellarpatrol.StellarPatrolGame;
import com.shootan.stellarpatrol.gameobjects.GameObjectsContainer;
import com.shootan.stellarpatrol.util.Constants;

/**
 * Created by geeksploit on 17.09.2017.
 */

public class CombatScreen extends InputAdapter implements Screen {

    private StellarPatrolGame game;

    private ExtendViewport combatViewport;
    private SpriteBatch spriteBatch;

    private Texture backgroundTexture;

    private GameObjectsContainer gameObjectsContainer;

    private boolean isDragging;

    public CombatScreen(StellarPatrolGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);

        combatViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
        spriteBatch = new SpriteBatch();

        backgroundTexture = Constants.BACKGROUND.random();

        gameObjectsContainer = new GameObjectsContainer();
    }

    @Override
    public void render(float delta) {
        combatViewport.apply();

        gameObjectsContainer.update(delta);

        spriteBatch.setProjectionMatrix(combatViewport.getCamera().combined);
        spriteBatch.begin();
        {
            spriteBatch.draw(backgroundTexture, 0, 0, combatViewport.getWorldWidth(), combatViewport.getWorldHeight());
            gameObjectsContainer.draw(spriteBatch);
        }
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        combatViewport.update(width, height, true);
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

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        combatViewport.unproject(gameObjectsContainer.preparePlayerDestination(screenX, screenY));
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        combatViewport.unproject(gameObjectsContainer.preparePlayerDestination(screenX, screenY));
        return super.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        combatViewport.unproject(gameObjectsContainer.preparePlayerDestination(screenX, screenY));
        return super.touchUp(screenX, screenY, pointer, button);
    }
}
