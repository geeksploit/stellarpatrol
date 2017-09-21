package com.shootan.stellarpatrol.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.shootan.stellarpatrol.StellarPatrolGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.addIcon("icons/icon_128x128.png", Files.FileType.Internal);
		config.addIcon("icons/icon_32x32.png", Files.FileType.Internal);
		config.addIcon("icons/icon_16x16.png", Files.FileType.Internal);
		config.title = "Stellar Patrol";

		float aspectRatio;

		new LwjglApplication(new StellarPatrolGame(), config);
	}
}
