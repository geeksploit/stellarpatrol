package com.shootan.stellarpatrol.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.shootan.stellarpatrol.StellarPatrolGame;
import com.shootan.stellarpatrol.util.Constants;

/**
 * Created by geeksploit on 17.09.2017.
 */

public class CombatScreen implements Screen {

    private StellarPatrolGame game;

    private ExtendViewport combatViewport;

    public CombatScreen(StellarPatrolGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        combatViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

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
