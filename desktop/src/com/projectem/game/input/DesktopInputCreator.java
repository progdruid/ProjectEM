package com.projectem.game.input;

public class DesktopInputCreator implements IPlatformInputCreator {
    @Override
    public IPlatformInput createInputManager(ICommonInputAcceptor acceptor) {
        return new DesktopInput(acceptor);
    }
}
