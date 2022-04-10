package com.projectem.game.ecs;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.projectem.game.CommonRender;
import com.projectem.game.Game;

import java.util.ArrayList;
import java.util.List;

public class SpriteSystem implements ISystem{

    private List<SpriteComponent> spriteComponents;
    private final Game game;


    public SpriteSystem (Game game) {
        this.spriteComponents = new ArrayList<>();
        this.game = game;
    }

    @Override
    public void update() {
        for (SpriteComponent comp : spriteComponents) {
            TransformComponent transform = (TransformComponent) (comp.getEntity().components.get("TransformComponent"));
            comp.sprite.setPosition(transform.x, transform.y);
            comp.sprite.setRotation(transform.rot);
            comp.sprite.setScale(transform.scaleX, transform.scaleY);
        }
    }

    @Override
    public IComponent createComponent(Entity entity) {
        SpriteComponent comp = new SpriteComponent(entity, this);
        entity.components.put(comp.getClass().getSimpleName(), comp);
        spriteComponents.add(comp);

        comp.sprite = new Sprite(comp.getTexture());
        comp.sprite.setOriginCenter();
        TransformComponent transform = (TransformComponent) entity.components.get("TransformComponent");
        if (transform == null)
            transform = (TransformComponent) game.systems.get("TransformSystem").createComponent(entity);

        comp.sprite.setPosition(transform.x, transform.y);
        comp.sprite.setRotation(transform.rot);
        comp.sprite.setScale(transform.scaleX, transform.scaleY);
        CommonRender.ins.sprites.put(entity.name, comp.sprite);

        return comp;
    }

    @Override
    public void deleteComponent(Entity entity) {
        SpriteComponent spriteComponent = (SpriteComponent) entity.components.get("SpriteComponent");

        CommonRender.ins.sprites.remove(entity.name);
        spriteComponents.remove(spriteComponent);
        entity.components.remove("SpriteComponent");
    }

    @Override
    public void dispose() {
        for (int i = 0; i < spriteComponents.size(); i++)
            spriteComponents.get(i).getEntity().components.remove(spriteComponents.get(i).getClass().getSimpleName());
        spriteComponents.clear();
    }
}
