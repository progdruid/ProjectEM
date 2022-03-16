package com.projectem.game.menu;

import com.projectem.game.menu.IMenu;
import com.projectem.game.menu.IMenuCreator;

public class DesktopMenuCreator implements IMenuCreator {
    @Override
    public IMenu createMenu(IMenuAcceptor acceptor) {
        return new DesktopMenu(acceptor);
    }
}
