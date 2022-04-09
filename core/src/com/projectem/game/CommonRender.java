package com.projectem.game;

import com.badlogic.gdx.utils.ScreenUtils;
import com.projectem.game.ecs.SpriteComponent;
import com.projectem.game.ui.IUIElement;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CommonRender {

    //region static
    public static CommonRender ins;

    public static void initializeRender () {
        ins = new CommonRender();
    }
    //endregion

    //region fields
    private int countOfLayers = 1;
    private SpriteBatch batch;
    private List<Sprite> sprites;
    private List<IUIElement> uiElements;
    private boolean isCamera = false;
    private Camera camera;
    //endregion

    public CommonRender () {
        batch = new SpriteBatch();
        sprites = new ArrayList<>();
        uiElements = new ArrayList<>();
    }

    //region api
    public void render(){
        ScreenUtils.clear(1, 0, 0, 1);

        if (isCamera)
            batch.setProjectionMatrix(camera.combined);

        batch.begin();

        //Sprites
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).draw(batch);
        }

        //UI
        for (IUIElement uiElement : uiElements) {
            uiElement.draw(batch);
        }

        batch.end();

        sprites.clear();
    }

    public void setCamera (Camera camera) {
        this.camera = camera;
    }

    public void toggleCamera (boolean state) {
        this.isCamera = state;
    }

    public void addSprite (Sprite sprite) {
        sprites.add(sprite);
    }

    public boolean removeSprite (Sprite sprite) {
        return sprites.remove(sprite);
    }

    public void addUIElement (IUIElement element) {
        uiElements.add(element);
    }

    public boolean removeUIElement (IUIElement element) {
        return uiElements.remove(element);
    }

    //endregion
}
