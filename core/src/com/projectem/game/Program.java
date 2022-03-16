package com.projectem.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.projectem.game.input.IInputManager;
import com.projectem.game.input.IInputManagerCreator;
import com.projectem.game.input.IUniversalInputAcceptor;
import com.projectem.game.menu.IMenu;
import com.projectem.game.menu.IMenuAcceptor;
import com.projectem.game.menu.IMenuCreator;
import com.projectem.game.ui.IUIAcceptor;
import com.projectem.game.ui.IUIManager;
import com.projectem.game.ui.IUIManagerCreator;

public class Program extends ApplicationAdapter implements IMenuAcceptor {

	IInputManagerCreator inputCreator;
	IUIManagerCreator uiCreator;
	IMenuCreator menuCreator;

	IMenu menu;

	public Program(IMenuCreator _menuCreator, IInputManagerCreator _inputCreator, IUIManagerCreator _uiCreator) {
		inputCreator = _inputCreator;
		uiCreator = _uiCreator;
		menuCreator = _menuCreator;
	}

	@Override
	public void create () {
		menu = menuCreator.createMenu(this);
	}

	@Override
	public void startGame() {

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
	}
	
	@Override
	public void dispose () {}
}
