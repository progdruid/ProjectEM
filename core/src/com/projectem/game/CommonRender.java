package com.projectem.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
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
    private SpriteBatch batch;
    private SpriteBatch uiBatch;

    public HashMap<String, Sprite> sprites;
    public List<IUIElement> uiElements;
    private Camera camera;
    //endregion

    public CommonRender () {
        uiBatch = new SpriteBatch();
        sprites = new HashMap<>();
        uiElements = new ArrayList<>();
    }

    //region api
    public void render(){
        ScreenUtils.clear(1, 0, 0, 1);

        if (camera != null) {
            batch.setProjectionMatrix(camera.combined);
            batch.begin();

            //Sprites
            for (Sprite sprite : sprites.values()) {
                sprite.draw(batch);
            }

            batch.end();
        }


        uiBatch.begin();
        for (IUIElement uiElement : uiElements) {
            uiElement.draw(uiBatch);
        }
        uiBatch.end();
    }

    public void setCamera(Camera camera) {
        batch = new SpriteBatch();
        this.camera = camera;
    }

    //endregion
}
