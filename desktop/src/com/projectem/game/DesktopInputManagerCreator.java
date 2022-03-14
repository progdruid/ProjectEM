package com.projectem.game;

public class DesktopInputManagerCreator implements IInputManagerCreator{
    @Override
    public IInputManager createInputManager(IUniversalInputAcceptor acceptor) {
        return new DesktopInputManager(acceptor);
    }
}
