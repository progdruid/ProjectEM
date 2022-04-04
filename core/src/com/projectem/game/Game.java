package com.projectem.game;

import com.projectem.game.input.*;
import com.projectem.game.ui.*;

public class Game implements IUIAcceptor, ICommonInputAcceptor {

    IUIManager uiManager;
    IPlatformInput inputManager;

    public Game (IUIManagerCreator uiCreator, IPlatformInputCreator inputCreator) {
        uiManager = uiCreator.createUIManager(this);
        inputManager = inputCreator.createInputManager(this);
    }

    public void update () {

    }

}
