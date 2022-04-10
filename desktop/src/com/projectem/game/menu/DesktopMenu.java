package com.projectem.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.projectem.game.CommonRender;
import com.projectem.game.ui.IButtonListener;
import com.projectem.game.ui.UIButton;

public class DesktopMenu implements IMenu, InputProcessor, IButtonListener {

    private final IMenuAcceptor acceptor;

    private final UIButton playButton;
    private final int playButtonHalfWidth = 80;
    private final int playButtonHalfHeight = 20;


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

        CommonRender.ins.uiElements.add(playButton);
        playButton.addListener(this);


    }

    @Override
    public void dispose() {
        CommonRender.ins.uiElements.remove(playButton);
        playButton.removeListener(this);
    }

    @Override
    public void buttonPressed() {
        acceptor.startMainGame();
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