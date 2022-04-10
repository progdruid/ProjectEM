package com.projectem.game.input;

import com.badlogic.gdx.math.Vector2;

public interface ICommonInputAcceptor {
    public void quitToMenu();
    public void move(Vector2 direction);
    public void move(Vector2 direction, float speed);
    public void zoom(float amount);
}
