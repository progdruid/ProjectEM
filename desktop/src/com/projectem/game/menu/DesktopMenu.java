package com.projectem.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.projectem.game.CommonRender;
import com.projectem.game.ui.IButtonListener;
import com.projectem.game.ui.UIButton;

public class DesktopMenu implements IMenu, InputProcessor, IButtonListener {

    IMenuAcceptor acceptor;

    UIButton playButton;
    int playButtonHalfWidth = 80;
    int playButtonHalfHeight = 20;


    public DesktopMenu (IMenuAcceptor _acceptor) {
        acceptor = _acceptor;
        Gdx.input.setInputProcessor(this);

        playButton = new UIButton(
                "Play",
                Gdx.graphics.getWidth() / 2 - playButtonHalfWidth,
                Gdx.graphics.getHeight() / 2 - playButtonHalfHeight,
                playButtonHalfWidth * 2,
                playButtonHalfHeight * 2,
                new BitmapFont (Gdx.files.internal("Font.fnt")));

        CommonRender.ins.addUIElement(playButton);
        playButton.addListener(this);


    }

    @Override
    public void update() {

    }

    @Override
    public void dispose() {
        CommonRender.ins.removeUIElement(playButton);
        playButton.removeListener(this);
    }

    @Override
    public void buttonPressed() {
        acceptor.startGame();
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
        if(button == 0)
            playButton.handlePointInteract(screenX, screenY);
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