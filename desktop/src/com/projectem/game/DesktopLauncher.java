package com.projectem.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.projectem.game.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		WindowMode mode = WindowMode.Fullscreen;
		int defaultWindowWidth = 1080;
		int defaultWindowHeight = 720;

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		Game game = new Game();

		if (mode == WindowMode.Windowed) {
			config.setResizable(false);
			config.setDecorated(true);
			config.setWindowedMode(defaultWindowWidth, defaultWindowHeight);
		}
		else if (mode == WindowMode.Windowed_Borderless) {
			config.setResizable(false);
			config.setDecorated(false);
			config.setWindowedMode(defaultWindowWidth, defaultWindowHeight);
		}
		else if (mode == WindowMode.Fullscreen)
		{
			config.setResizable(false);
			config.setDecorated(false);
			config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
		}
		config.setForegroundFPS(60);

		Lwjgl3Application application = new Lwjgl3Application(game, config);
	}
}
