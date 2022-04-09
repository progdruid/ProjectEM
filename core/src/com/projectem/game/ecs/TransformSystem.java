package com.projectem.game.ecs;

import java.util.ArrayList;
import java.util.List;

public class TransformSystem implements ISystem{

    private List<TransformComponent> transforms;

    public TransformSystem () {
        transforms = new ArrayList<>();
    }

    @Override
    public void update() {

    }

    @Override
    public IComponent createComponent(Entity entity) {
        TransformComponent transform = new TransformComponent(entity, this);
        entity.components.put(transform.getClass().getSimpleName(), transform);
        transforms.add(transform);
        return transform;
    }

    @Override
    public void deleteComponent(Entity entity) {
        TransformComponent transform = (TransformComponent) entity.components.get("TransformComponent");
        entity.components.remove("TransformComponent");
        transforms.remove(transform);
    }

    @Override
    public void dispose() {
        for (int i = 0; i < transforms.size(); i++)
            transforms.get(i).getEntity().components.remove(transforms.get(i).getClass().getSimpleName());
        transforms.clear();;
    }
}
