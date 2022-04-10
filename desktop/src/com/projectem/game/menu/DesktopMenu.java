package com.projectem.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.projectem.game.CommonRender;
import com.projectem.game.ui.IButtonListener;
import com.projectem.game.ui.UIButton;

public class DesktopMenu implements IMenu, InputProcessor, IButtonListener {

    private final ISceneManager sceneManager;

    private final UIButton playButton;
    private final UIButton quitButton;
    private final int buttonHalfWidth = 80;
    private final int buttonHalfHeight = 20;


    public DesktopMenu (ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
        Gdx.input.setInputProcessor(this);

        playButton = new UIButton(
                "Play",
                Gdx.graphics.getWidth() / 2 - buttonHalfWidth,
                Gdx.graphics.getHeight() / 2 - buttonHalfHeight,
                buttonHalfWidth * 2,
                buttonHalfHeight * 2,
                new BitmapFont (Gdx.files.internal("Font.fnt"))
        );

        CommonRender.ins.uiElements.add(playButton);
        this.playButton.addListener(this);


        quitButton = new UIButton(
                "Quit",
                Gdx.graphics.getWidth() / 2 - buttonHalfWidth,
                (int)(Gdx.graphics.getHeight() / 2 - 3.5f * buttonHalfHeight),
                buttonHalfWidth * 2,
                buttonHalfHeight * 2,
                new BitmapFont (Gdx.files.internal("Font.fnt"))
        );

        CommonRender.ins.uiElements.add(quitButton);
        this.quitButton.addListener(this);
    }

    @Override
    public void dispose() {
        CommonRender.ins.uiElements.remove(this.playButton);
        CommonRender.ins.uiElements.remove(this.quitButton);
        this.playButton.removeListener(this);
        this.quitButton.removeListener(this);
    }

    @Override
    public void handleButtonPress(String buttonName) {
        if (buttonName == "Play") {
            dispose();
            sceneManager.startMainGame();
        }
        else if (buttonName == "Quit"){
            dispose();
            sceneManager.quitGame();
        }

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
        {
            playButton.handlePointInteract(screenX, screenY);
            quitButton.handlePointInteract(screenX, screenY);
        }
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