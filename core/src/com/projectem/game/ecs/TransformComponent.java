package com.projectem.game.ecs;

public class TransformComponent implements IComponent{

    private final Entity entity;

    public int x = 0, y = 0;
    public float scaleX = 1f, scaleY = 1f;
    public float rot = 0;

    public TransformComponent (Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    @Override
    public IComponentSystem getSystem() {
        return TransformSystem.ins;
    }
}
