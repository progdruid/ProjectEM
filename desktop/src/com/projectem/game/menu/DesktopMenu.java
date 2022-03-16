package com.projectem.game.menu;

public class DesktopMenu implements IMenu {

    IMenuAcceptor acceptor;

    public DesktopMenu (IMenuAcceptor _acceptor) {
        acceptor = _acceptor;
    }

    @Override
    public void render() {

    }
}