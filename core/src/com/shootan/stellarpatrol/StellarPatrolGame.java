package com.shootan.stellarpatrol;

import com.badlogic.gdx.Game;
import com.shootan.stellarpatrol.screens.CombatScreen;
import com.shootan.stellarpatrol.screens.DifficultyScreen;

public class StellarPatrolGame extends Game {

	@Override
	public void create() {
		showDifficultyScreen();
	}

	public void setCombatScreen() {
		setScreen(new CombatScreen(this));
	}

	public void showDifficultyScreen() {
		setScreen(new DifficultyScreen(this));
	}
}
