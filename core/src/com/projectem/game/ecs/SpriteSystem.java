package com.projectem.game.ecs;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.projectem.game.CommonRender;

import java.util.ArrayList;
import java.util.List;

public class SpriteSystem implements IComponentSystem {

    //region static
    public static SpriteSystem ins;
    public static void init () {
        ins = new SpriteSystem();
    }
    //endregion

    private List<SpriteComponent> spriteComponents;


    public SpriteSystem() {
        this.spriteComponents = new ArrayList<>();
    }

    @Override
    public void update() {
        for (SpriteComponent comp : spriteComponents) {
            TransformComponent transform = comp.getEntity().transform;
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
        comp.sprite.setCenter(entity.transform.x, entity.transform.y);
        comp.sprite.setRotation(entity.transform.rot);
        comp.sprite.setScale(entity.transform.scaleX, entity.transform.scaleY);
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
