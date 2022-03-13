package com.projectem.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	OrthographicCamera camera;

	@Override
	public void create () {
		Gdx.input.setInputProcessor(this);

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Sprite(img);
		sprite.setOrigin(0, 0);
		sprite.setPosition(-sprite.getWidth()/2, - sprite.getHeight()/2);
		camera = new OrthographicCamera(12800, 7200);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//batch.draw(img, 0, 0);
		sprite.draw(batch);
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	//region Input handlers
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.ESCAPE){
			Gdx.app.exit();
			return true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		camera.translate(-(screenX - Gdx.graphics.getWidth() / 2) / 100, (screenY - Gdx.graphics.getHeight() / 2) / 100);
		camera.update();
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		camera.zoom += amountY / 10;
		camera.update();
		return false;
	}
	//endregion
}
