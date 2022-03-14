package com.projectem.game.ui;

import com.projectem.game.Game;

public class DesktopUIManagerCreator implements IUIManagerCreator {

    @Override
    public IUIManager createUIManager(IUIAcceptor acceptor) {
        return new DesktopUIManager (acceptor);
    }
}
