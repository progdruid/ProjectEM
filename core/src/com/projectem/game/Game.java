package com.projectem.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.projectem.game.ecs.*;
import com.projectem.game.input.*;
import com.projectem.game.ui.*;

public class Game implements IUIAcceptor, ICommonInputAcceptor, Disposable {

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
        EntityGod.init();

        TransformSystem.init();
        SpriteSystem.init();

        inputManager.startProcessing();

        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        CommonRender.ins.camera = this.camera;
        CommonRender.ins.useCamera = true;

        Entity body = new Entity("Body");
        TransformSystem.ins.createComponent(body);
        SpriteComponent spriteComponent = (SpriteComponent) SpriteSystem.ins.createComponent(body);
        spriteComponent.setTexture(new Texture(Gdx.files.internal("badlogic.jpg")));

    }

    public void logicUpdate () {
        TransformSystem.ins.update();
    }

    public void frameUpdate() {
        inputManager.update();

        SpriteSystem.ins.update();
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
        SpriteSystem.ins.dispose();
        TransformSystem.ins.dispose();
    }

    @Override
    public void exitMainGame() {
        dispose();
        Gdx.app.exit();
    }
}
