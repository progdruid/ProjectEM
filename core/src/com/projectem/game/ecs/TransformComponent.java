package com.projectem.game.ecs;

public class TransformComponent implements IComponent{

    private final Entity entity;
    private final TransformSystem system;

    public int x = 0, y = 0;
    public float scaleX = 1f, scaleY = 1f;
    public float rot = 0;

    public TransformComponent (Entity entity, TransformSystem system) {
        this.entity = entity;
        this.system = system;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    @Override
    public ISystem getSystem() {
        return system;
    }
}
