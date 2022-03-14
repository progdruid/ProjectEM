package com.projectem.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {

	IUIManager ui;

	public Game (IUIManagerCreator uiCreator) {
		ui = uiCreator.createUIManager(this);
	}

	@Override
	public void create () {

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
	}
	
	@Override
	public void dispose () {

	}
}
