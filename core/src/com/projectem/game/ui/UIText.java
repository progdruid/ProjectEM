package com.projectem.game.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class UIText implements IUIElement {
    public final String text;
    public final int x;
    public final int y;
    public final int size;
    public final BitmapFont font;

    private GlyphLayout layout;

    public UIText (String text, int x, int y, int size, BitmapFont font) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.size = size;
        this.font = font;
        this.layout = new GlyphLayout();
        layout.setText(font, text);
    }

    @Override
    public void draw(SpriteBatch batch) {
        font.draw(batch, layout, x - layout.width/2, y + layout.height/2);
    }
}
