package com.projectem.game.ui;

import com.projectem.game.Game;

public class DesktopUIManagerCreator implements IUIManagerCreator {

    @Override
    public IUIManager createUIManager(Game game) {
        return new DesktopUIManager (game);
    }
}
