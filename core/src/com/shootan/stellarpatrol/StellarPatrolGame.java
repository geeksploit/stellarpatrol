package com.shootan.stellarpatrol;

import com.badlogic.gdx.Game;
import com.shootan.stellarpatrol.screens.DifficultyScreen;

public class StellarPatrolGame extends Game {

	@Override
	public void create() {
		showDifficultyScreen();
	}

	public void showDifficultyScreen() {
		setScreen(new DifficultyScreen(this));
	}
}
