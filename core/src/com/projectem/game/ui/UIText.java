package com.projectem.game.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UIText implements IUIElement {
    public final String text;
    public final int x;
    public final int y;
    public final int size;
    public final BitmapFont font;

    public UIText (String text, int x, int y, int size, BitmapFont font) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.size = size;
        this.font = font;
    }

    @Override
    public void draw(SpriteBatch batch) {
        font.draw(batch, text, x, y);
    }
}
