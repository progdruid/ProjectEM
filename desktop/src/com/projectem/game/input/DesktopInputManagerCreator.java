package com.projectem.game.input;

public class DesktopInputManagerCreator implements IInputManagerCreator {
    @Override
    public IInputManager createInputManager(IUniversalInputAcceptor acceptor) {
        return new DesktopInputManager(acceptor);
    }
}
