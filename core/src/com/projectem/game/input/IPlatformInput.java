package com.projectem.game.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public interface IPlatformInput extends InputProcessor {
    public void startProcessing ();
    public void update();
}
