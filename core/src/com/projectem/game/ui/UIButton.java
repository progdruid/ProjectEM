package com.projectem.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UIButton implements IUIElement {

    private final List<IButtonListener> listeners;
    private final UIText text;
    private final int x, y;
    private final int width, height;

    private final ShapeRenderer shapeRenderer; //will be deleted


    public UIButton (String text, int x, int y, int width, int height, BitmapFont font) {
        listeners = new ArrayList<IButtonListener>();
        this.text = new UIText(text, x + width/2, y + height/2, font);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        shapeRenderer = new ShapeRenderer(); //will be deleted
        shapeRenderer.setAutoShapeType(true);//
    }

    @Override
    public void draw(SpriteBatch batch) {

        //region will be deleted
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.CORAL);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
        batch.begin();
        //endregion

        text.draw(batch);
    }

    public void handlePointInteract(int x, int y) {
        if (x >= this.x && x < this.x + this.width && y >= this.y && y < this.y + this.height)
            invoke();
    }

    private void invoke () {
        for (int i = 0; i < listeners.size(); i++)
            listeners.get(i).buttonPressed();
    }

    public void addListener (IButtonListener listener) {
        listeners.add(listener);
    }

    public void removeListener (IButtonListener listener) throws NoSuchElementException {
        if (!listeners.contains(listener))
            throw new NoSuchElementException("There is no such button listener as was given.");
        listeners.remove(listener);
    }
}
