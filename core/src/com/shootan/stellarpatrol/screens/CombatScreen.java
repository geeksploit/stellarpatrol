package com.shootan.stellarpatrol.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.shootan.stellarpatrol.StellarPatrolGame;
import com.shootan.stellarpatrol.gameobjects.GameObjectsContainer;
import com.shootan.stellarpatrol.screens.overlays.CombatGui;
import com.shootan.stellarpatrol.util.Constants;

/**
 * Created by geeksploit on 17.09.2017.
 */

public class CombatScreen extends InputAdapter implements Screen {

    private StellarPatrolGame game;

    private FillViewport combatViewport;
    private ScreenViewport guiViewport;
    private SpriteBatch spriteBatch;

    private BitmapFont bitmapFont;
    private Music backgroundMusicLoop;
    private Texture backgroundTexture;

    private CombatGui combatGui;
    private GameObjectsContainer gameObjectsContainer;

    private boolean isDragging;

    public CombatScreen(StellarPatrolGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);

        combatViewport = new FillViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
        guiViewport = new ScreenViewport();

        spriteBatch = new SpriteBatch();

        bitmapFont = new BitmapFont();
        bitmapFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        backgroundTexture = Constants.BACKGROUND.random();

        gameObjectsContainer = new GameObjectsContainer();

        combatGui = new CombatGui();
        combatGui.setViewport(guiViewport);
        combatGui.setSpriteBatch(spriteBatch);
        combatGui.setFont(bitmapFont);

        backgroundMusicLoop = Constants.BACKGROUND_MUSIC_LOOPS.random();
        backgroundMusicLoop.setLooping(true);
        backgroundMusicLoop.play();
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

        combatGui.render(delta);

        cameraFollowPlayer();
    }

    @Override
    public void resize(int width, int height) {
        combatViewport.update(width, height, true);
        guiViewport.update(width, height, true);
    }

    @Override
    public void pause() {
        backgroundMusicLoop.pause();
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        backgroundMusicLoop.stop();
    }

    @Override
    public void dispose() {
        backgroundMusicLoop.dispose();
        backgroundTexture.dispose();
        bitmapFont.dispose();
        spriteBatch.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button != Input.Buttons.LEFT || pointer > 0) return false;
        isDragging = true;
        combatViewport.unproject(gameObjectsContainer.preparePlayerDestination(screenX, screenY));
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (!isDragging) return false;
        combatViewport.unproject(gameObjectsContainer.preparePlayerDestination(screenX, screenY));
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (button != Input.Buttons.LEFT || pointer > 0) return false;
        isDragging = false;
        combatViewport.unproject(gameObjectsContainer.preparePlayerDestination(screenX, screenY));
        return true;
    }

    private void cameraFollowPlayer() {
        float aspectRatio = (float) Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
        float halfWorldWidth = combatViewport.getWorldWidth() * aspectRatio / 2;
        float targetPositionX = MathUtils.clamp(
                gameObjectsContainer.getPlayerPosition().x,
                halfWorldWidth,
                Constants.WORLD_SIZE - halfWorldWidth);
        OrthographicCamera camera = (OrthographicCamera) combatViewport.getCamera();
        camera.position.x = MathUtils.lerp(camera.position.x, targetPositionX, .1f);
    }
}
