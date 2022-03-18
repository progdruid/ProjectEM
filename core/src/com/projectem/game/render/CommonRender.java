package com.projectem.game.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.projectem.game.ui.IUIElement;
import com.projectem.game.ui.UIText;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
    int countOfLayers = 1;
    SpriteBatch batch;
    List<Sprite>[] spriteLayers;
    List<IUIElement> uiElements;
    BitmapFont font;
    //endregion

    public CommonRender () {
        batch = new SpriteBatch();
        spriteLayers = new List[countOfLayers];
        for (int i = 0; i < countOfLayers; i++)
            spriteLayers[i] = new ArrayList<>();
        uiElements = new ArrayList<>();
        //FileHandle
        font = new BitmapFont(Gdx.files.internal("Font.fnt")); //there should be font file
    }

    //region api
    public void render(){
        ScreenUtils.clear(1, 0, 0, 1);

        batch.begin();

        for (int i = 0; i < countOfLayers; i++) {
            for (int j = 0; j < spriteLayers[i].size(); j++) {
                spriteLayers[i].get(j).draw(batch);
            }
        }

        for (int i = 0; i < uiElements.size(); i++) {
            uiElements.get(i).draw(batch);
        }

        batch.end();
    }

    public BitmapFont getFont () {
        return font;
    }

    public void setCamera (Camera camera) {
        batch.setProjectionMatrix(camera.combined);
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
