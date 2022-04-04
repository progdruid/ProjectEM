package com.projectem.game;

import com.badlogic.gdx.utils.ScreenUtils;
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
    private List<Sprite>[] spriteLayers;
    private List<IUIElement> uiElements;
    private Camera camera;
    //endregion

    public CommonRender () {
        batch = new SpriteBatch();
        spriteLayers = new ArrayList[countOfLayers];
        for (int i = 0; i < countOfLayers; i++)
            spriteLayers[i] = new ArrayList<>();
        uiElements = new ArrayList<>();
    }

    //region api
    public void render(){
        ScreenUtils.clear(1, 0, 0, 1);

        if (camera != null)
            batch.setProjectionMatrix(camera.combined);

        batch.begin();

        for (int i = 0; i < countOfLayers; i++) {
            for (int j = 0; j < spriteLayers[i].size(); j++) {
                spriteLayers[i].get(j).draw(batch);
            }
        }

        for (IUIElement uiElement : uiElements) {
            uiElement.draw(batch);
        }

        batch.end();
    }

    public void setCamera (Camera camera) {
        this.camera = camera;
    }

    public void addSprite (Sprite sprite, int layer) {
        spriteLayers[layer].add(sprite);
    }

    public void removeSprite (Sprite sprite, int layer) throws NoSuchElementException {
        boolean res = spriteLayers[layer].remove(sprite);
        if (!res)
            throw new NoSuchElementException("There is no such sprite in the layer like was given.");
    }

    public void addUIElement (IUIElement element) {
        uiElements.add(element);
    }

    public void removeUIElement (IUIElement element) {
        boolean res = uiElements.remove(element);
        if (!res)
            throw new NoSuchElementException("There is no such UI element");
    }

    //endregion
}
