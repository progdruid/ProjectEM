package com.projectem.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.projectem.game.ecs.*;
import com.projectem.game.input.*;
import com.projectem.game.ui.*;

import java.util.HashMap;

public class Game implements IUIAcceptor, ICommonInputAcceptor, Disposable {

    private final IUIManager uiManager;
    private final IPlatformInput inputManager;

    private HashMap<String, ISystem> systems;

    private OrthographicCamera camera;
    private final float cameraSpeed = 0.25f;
    private final float minZoom = 0.5f;
    private final float maxZoom = 10f;

    public Game (IUIManagerCreator uiCreator, IPlatformInputCreator inputCreator) {
        uiManager = uiCreator.createUIManager(this);
        inputManager = inputCreator.createInputManager(this);
    }

    public void start () {
        EntityGod.init();
        systems = new HashMap<>();
        //creating
        //systems

        inputManager.startProcessing();

        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        CommonRender.ins.camera = this.camera;
        CommonRender.ins.useCamera = true;

        Texture tex = new Texture(Gdx.files.internal("badlogic.jpg"));
        Sprite sprite = new Sprite(tex);

        CommonRender.ins.sprites.put("badlogic", sprite);
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

    @Override
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

    @Override
    public void dispose() {
        EntityGod.ins.dispose();
        String[] keys = systems.keySet().toArray(new String[0]);
        for (int i = 0; i < keys.length; i++){
            systems.get(keys[i]).dispose();
        }
        systems.clear();
    }

    public void exitGame () {
        dispose();
    }
}
