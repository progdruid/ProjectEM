package com.projectem.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.projectem.game.input.IInputManagerCreator;
import com.projectem.game.menu.IMenu;
import com.projectem.game.menu.IMenuAcceptor;
import com.projectem.game.menu.IMenuCreator;
import com.projectem.game.render.CommonRender;
import com.projectem.game.ui.IUIManagerCreator;

public class Program extends ApplicationAdapter implements IMenuAcceptor {
	IInputManagerCreator inputCreator;
	IUIManagerCreator gameUICreator;
	IMenuCreator menuCreator;

	IMenu menu;

	public Program(IMenuCreator menuCreator, IInputManagerCreator inputCreator, IUIManagerCreator gameUICreator) {
		this.inputCreator = inputCreator;
		this.gameUICreator = gameUICreator;
		this.menuCreator = menuCreator;

		CommonRender.initializeRender();
	}

	@Override
	public void create (){
		menu = menuCreator.openMenu(this);
	}

	@Override
	public void render () {
		CommonRender.ins.render();//multithreading is needed
	}

	@Override
	public void startGame() {
		menu.dispose();
		//init of the game class
	}

	@Override
	public void dispose () {}
}
