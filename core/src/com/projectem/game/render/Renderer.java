package com.projectem.game.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.projectem.game.ui.IUIElement;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Renderer {

    //region static
    public static Renderer ins;

    public static void initializeRender () {
        ins = new Renderer();
    }
    //endregion

    //region fields
    private SpriteBatch batch;
    private SpriteBatch uiBatch;

    public HashMap<String, Sprite> sprites;
    public List<IUIElement> uiElements;

    private OrthographicCamera camera;
    //endregion

    public Renderer() {
        uiBatch = new SpriteBatch();
        sprites = new HashMap<>();
        uiElements = new ArrayList<>();
    }

    //region api
    public void render(){
        ScreenUtils.clear(43 / 256f, 41 / 256f, 61 / 256f, 1);

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

    public OrthographicCamera getCamera () {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        batch = new SpriteBatch();
        this.camera = camera;
    }

    //endregion
}
