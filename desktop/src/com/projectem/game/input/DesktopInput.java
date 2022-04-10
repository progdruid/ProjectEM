package com.projectem.game.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class DesktopInput implements IPlatformInput {
    ICommonInputAcceptor acceptor;

    public DesktopInput(ICommonInputAcceptor acceptor) {
        this.acceptor = acceptor;
    }

    @Override
    public void startProcessing() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void update() {
        //translation
        Vector2 movedir = new Vector2();

        if (Gdx.input.isKeyPressed(Input.Keys.W))
            movedir.y = 1;
        else if (Gdx.input.isKeyPressed(Input.Keys.S))
            movedir.y = -1;
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            movedir.x = 1;
        else if (Gdx.input.isKeyPressed(Input.Keys.A))
            movedir.x = -1;
        movedir.nor();
        if (movedir.x != 0 || movedir.y != 0)
            acceptor.move(movedir);

        //zoom
        if (Gdx.input.isKeyPressed(Input.Keys.Q))
            acceptor.zoom(0.02f);
        else if (Gdx.input.isKeyPressed(Input.Keys.E))
            acceptor.zoom(-0.02f);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ESCAPE) {
            acceptor.exitMainGame();
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
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        acceptor.zoom(amountY * 0.1f);
        return false;
    }
}
