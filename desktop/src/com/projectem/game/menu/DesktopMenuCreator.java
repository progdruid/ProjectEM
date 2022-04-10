package com.projectem.game.menu;

public class DesktopMenuCreator implements IMenuCreator {
    @Override
    public IMenu openMenu(ISceneManager sceneManager) {
        return new DesktopMenu(sceneManager);
    }
}
