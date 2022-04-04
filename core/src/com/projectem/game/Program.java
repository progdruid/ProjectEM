package com.projectem.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.projectem.game.input.IPlatformInputCreator;
import com.projectem.game.menu.IMenu;
import com.projectem.game.menu.IMenuAcceptor;
import com.projectem.game.menu.IMenuCreator;
import com.projectem.game.ui.IUIManagerCreator;

public class Program extends ApplicationAdapter implements IMenuAcceptor {
	IPlatformInputCreator inputCreator;
	IUIManagerCreator gameUICreator;
	IMenuCreator menuCreator;

	IMenu menu;

	Game game;

	public Program(IMenuCreator menuCreator, IPlatformInputCreator inputCreator, IUIManagerCreator gameUICreator) {
		this.inputCreator = inputCreator;
		this.gameUICreator = gameUICreator;
		this.menuCreator = menuCreator;
	}

	@Override
	public void create (){
		CommonRender.initializeRender();

		menu = menuCreator.openMenu(this);
	}

	@Override
	public void render () {
		CommonRender.ins.render();//multithreading is needed
	}

	@Override
	public void startGame() {
		this.menu.dispose();

		this.game = new Game(gameUICreator, inputCreator);
		//Gdx.app.exit();
		//init of the game class
	}

	@Override
	public void dispose () {}
}
