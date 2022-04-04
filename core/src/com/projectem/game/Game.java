package com.projectem.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.projectem.game.input.*;
import com.projectem.game.ui.*;

public class Game implements IUIAcceptor, ICommonInputAcceptor {

    private final IUIManager uiManager;
    private final IPlatformInput inputManager;

    public Game (IUIManagerCreator uiCreator, IPlatformInputCreator inputCreator) {
        uiManager = uiCreator.createUIManager(this);
        inputManager = inputCreator.createInputManager(this);
    }

    public void start () {

    }

    public void update () {

    }

}
