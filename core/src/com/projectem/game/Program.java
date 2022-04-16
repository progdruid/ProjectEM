package com.projectem.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.projectem.game.input.*;
import com.projectem.game.menu.*;
import com.projectem.game.render.Renderer;
import com.projectem.game.ui.*;

public class Program extends ApplicationAdapter implements ISceneManager {
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
		Renderer.initializeRender();

		openMainMenu();
	}

	@Override
	public void startMainGame() {
		this.game = new Game(this.gameUICreator, this.inputCreator, this);
		this.state = GameState.Game;

		this.game.start();
	}

	@Override
	public void render () {
		if (this.state == GameState.Game){
			this.game.frameUpdate();
			this.game.logicUpdate();
		}
//		else if (this.state == GameState.Menu)
//			this.menu.update();

		Renderer.ins.render();//multithreading is needed
	}

	@Override
	public void openMainMenu() {
		this.state = GameState.Menu;
		this.menu = menuCreator.openMenu(this);
	}

	@Override
	public void dispose () {}

	@Override
	public void quitGame() {
		dispose();
		Gdx.app.exit();
	}
}
