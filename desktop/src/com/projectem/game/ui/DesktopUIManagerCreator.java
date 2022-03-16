package com.projectem.game.ui;

public class DesktopUIManagerCreator implements IUIManagerCreator {

    @Override
    public IUIManager createUIManager(IUIAcceptor acceptor) {
        return new DesktopUIManager (acceptor);
    }
}
