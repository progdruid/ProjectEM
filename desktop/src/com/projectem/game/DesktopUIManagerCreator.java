package com.projectem.game;

public class DesktopUIManagerCreator implements IUIManagerCreator {

    @Override
    public IUIManager createUIManager(Game game) {
        return new DesktopUIManager (game);
    }
}
