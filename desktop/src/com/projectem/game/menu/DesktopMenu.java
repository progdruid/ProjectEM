package com.projectem.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;
import com.projectem.game.render.CommonRender;
import com.projectem.game.ui.UIText;

public class DesktopMenu implements IMenu, InputProcessor {

    IMenuAcceptor acceptor;

    UIText playButtonText;
    int playButtonHalfWidth = 40;
    int playButtonHalfHeight = 10;


    public DesktopMenu (IMenuAcceptor _acceptor) {
        acceptor = _acceptor;
        Gdx.input.setInputProcessor(this);

        playButtonText = new UIText(
                "Play",
                Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() /2,
                0,
                new BitmapFont(Gdx.files.internal("Font.fnt")));

        CommonRender.ins.addUIElement(playButtonText);

        //UI image
    }

    @Override
    public void render() {

    }

    @Override
    public void dispose() {

    }

    //region InputProcessor handlers
    @Override
    public boolean keyDown(int keycode) {
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
        acceptor.startGame();
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
        return false;
    }
    //endregion
}