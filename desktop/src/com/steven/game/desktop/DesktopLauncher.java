package com.steven.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.steven.game.FeridunBirds;

public class DesktopLauncher {
	public DesktopLauncher() {
	}

	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 480;
		config.height = 800;
		config.title = "Feridun Bird";
		new LwjglApplication(new FeridunBirds(), config);
	}
}
