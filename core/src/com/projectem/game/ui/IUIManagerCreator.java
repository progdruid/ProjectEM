package com.projectem.game.ui;

import com.projectem.game.Game;

public interface IUIManagerCreator {
    public IUIManager createUIManager(IUIAcceptor acceptor);
}
