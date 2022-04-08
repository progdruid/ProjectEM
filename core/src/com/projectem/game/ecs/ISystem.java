package com.projectem.game.ecs;

public interface ISystem {
    public void update();
    public void createComponent(Entity entity);
    public void deleteComponent(Entity entity);
    public IComponent getComponent(Entity entity);
}
