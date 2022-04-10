package com.projectem.game;

import com.badlogic.gdx.utils.ScreenUtils;
import com.projectem.game.ui.IUIElement;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommonRender {

    //region static
    public static CommonRender ins;

    public static void initializeRender () {
        ins = new CommonRender();
    }
    //endregion

    //region fields
    //private int countOfLayers = 1;
    private SpriteBatch batch;

    public HashMap<String, Sprite> sprites;
    public List<IUIElement> uiElements;
    public boolean useCamera = false;
    public Camera camera;
    //endregion

    public CommonRender () {
        batch = new SpriteBatch();
        sprites = new HashMap<>();
        uiElements = new ArrayList<>();
    }

    //region api
    public void render(){
        ScreenUtils.clear(1, 0, 0, 1);

        if (useCamera)
            batch.setProjectionMatrix(camera.combined);

        batch.begin();

        //Sprites
        for (Sprite sprite : sprites.values()) {
            sprite.draw(batch);
        }

        //UI
        for (IUIElement uiElement : uiElements) {
            uiElement.draw(batch);
        }

        batch.end();
    }

    //endregion
}
