package com.projectem.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.projectem.game.input.IInputManager;
import com.projectem.game.input.IInputManagerCreator;
import com.projectem.game.input.IUniversalInputAcceptor;
import com.projectem.game.ui.IUIManager;
import com.projectem.game.ui.IUIManagerCreator;

public class Game extends ApplicationAdapter implements IUniversalInputAcceptor {

	IInputManager inputManager;
	IUIManager ui;

	public Game (IInputManagerCreator inputCreator, IUIManagerCreator uiCreator) {
		inputManager = inputCreator.createInputManager(this);
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
