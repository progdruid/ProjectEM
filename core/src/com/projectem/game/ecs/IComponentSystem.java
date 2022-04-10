package com.projectem.game.ecs;

import com.badlogic.gdx.utils.Disposable;

public interface IComponentSystem extends Disposable {
    public void update();
    public IComponent createComponent(Entity entity);
    public void deleteComponent(Entity entity);
}
