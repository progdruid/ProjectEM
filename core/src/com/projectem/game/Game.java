package com.projectem.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.projectem.game.input.*;
import com.projectem.game.ui.*;

public class Game implements IUIAcceptor, ICommonInputAcceptor {

    private final IUIManager uiManager;
    private final IPlatformInput inputManager;

    private OrthographicCamera camera;
    private final float cameraSpeed = 0.25f;
    private final float minZoom = 0.5f;
    private final float maxZoom = 10f;

    public Game (IUIManagerCreator uiCreator, IPlatformInputCreator inputCreator) {
        uiManager = uiCreator.createUIManager(this);
        inputManager = inputCreator.createInputManager(this);
    }

    public void start () {
        inputManager.startProcessing();

        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        CommonRender.ins.setCamera(this.camera);
        CommonRender.ins.toggleCamera(true);

        Texture tex = new Texture(Gdx.files.internal("badlogic.jpg"));
        Sprite sprite = new Sprite(tex);

        CommonRender.ins.addSprite(sprite, 0);
    }

    public void logicUpdate () {

    }

    public void frameUpdate() {
        inputManager.update();
    }

    @Override
    public void move(Vector2 direction) {
        move(direction, cameraSpeed);
    }

    @Override
    public void move(Vector2 direction, float speed) {
        camera.translate(direction.scl((camera.zoom + 1) * camera.viewportWidth * speed * Gdx.graphics.getDeltaTime()));
        camera.update();
    }

    public void zoom(float amount) {
        float nextZoom = camera.zoom + amount * (camera.zoom + 1);
        if (nextZoom < minZoom)
            camera.zoom = minZoom;
        else if (nextZoom > maxZoom)
            camera.zoom = maxZoom;
        else
            camera.zoom = nextZoom;
        camera.update();
    }
}
