package com.projectem.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.projectem.game.input.*;
import com.projectem.game.menu.*;
import com.projectem.game.ui.*;

public class Program extends ApplicationAdapter implements IMenuAcceptor {
	private final IPlatformInputCreator inputCreator;
	private final IUIManagerCreator gameUICreator;
	private final IMenuCreator menuCreator;

	private IMenu menu;
	private Game game;

	private GameState state;

	public Program(IMenuCreator menuCreator, IPlatformInputCreator inputCreator, IUIManagerCreator gameUICreator) {
		this.inputCreator = inputCreator;
		this.gameUICreator = gameUICreator;
		this.menuCreator = menuCreator;
	}

	@Override
	public void create (){
		CommonRender.initializeRender();

		this.menu = menuCreator.openMenu(this);
		this.state = GameState.Menu;
	}

	@Override
	public void render () {
		CommonRender.ins.render();//multithreading is needed

		if (this.state == GameState.Game)
			this.game.renderUpdate();
//		else if (this.state == GameState.Menu)
//			this.menu.update();
	}

	@Override
	public void startGame() {
		this.menu.dispose();

		this.game = new Game(this.gameUICreator, this.inputCreator);
		this.state = GameState.Game;

		this.game.start();
	}

	@Override
	public void dispose () {}
}
