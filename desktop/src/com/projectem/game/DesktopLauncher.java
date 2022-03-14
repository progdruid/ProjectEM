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

		Lwjgl3ApplicationConfiguration config = CreateAppConfig(mode, defaultWindowWidth, defaultWindowHeight);
		Game game = new Game(new DesktopInputManagerCreator(), new DesktopUIManagerCreator());

		Lwjgl3Application app = new Lwjgl3Application(game, config);
	}

	private static Lwjgl3ApplicationConfiguration CreateAppConfig (WindowMode mode, int windowWidth, int windowHeight)
	{
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();


		if (mode == WindowMode.Windowed) {
			config.setResizable(false);
			config.setDecorated(true);
			config.setWindowedMode(windowWidth, windowHeight);
		}
		else if (mode == WindowMode.Windowed_Borderless) {
			config.setResizable(false);
			config.setDecorated(false);
			config.setWindowedMode(windowWidth, windowHeight);
		}
		else if (mode == WindowMode.Fullscreen)
		{
			config.setResizable(false);
			config.setDecorated(false);
			config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
		}
		config.setForegroundFPS(60);

		return config;
	}
}
