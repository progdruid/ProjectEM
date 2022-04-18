package com.projectem.game.ecs;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteComponent implements IComponent{

    private final Entity entity;

    private Texture texture;
    public Sprite sprite;

    public SpriteComponent (Entity entity) {
        this.entity = entity;

        Pixmap pixmap = new Pixmap(128, 128, Pixmap.Format.RGB888);
        pixmap.setColor(Color.MAGENTA);
        pixmap.fill();
        this.texture = new Texture(pixmap);
    }

    public Texture getTexture () {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
        sprite.setTexture(texture);
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    @Override
    public IComponentSystem getSystem() {
        return SpriteSystem.ins;
    }
}
