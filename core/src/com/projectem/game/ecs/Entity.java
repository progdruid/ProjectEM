package com.projectem.game.ecs;

import com.badlogic.gdx.utils.Disposable;
import java.util.HashMap;

public class Entity implements Disposable {

    public String name = "";
    public HashMap<String, IComponent> components;
    public TransformComponent transform;

    public Entity (String name) {
        EntityGod.ins.entities.add(this);
        this.name = name;
        this.components = new HashMap<>();
        transform = (TransformComponent) TransformSystem.ins.createComponent(this);
    }

    public void dispose (){
        String[] keys = components.keySet().toArray(new String[0]);
        for (int i = 0; i < keys.length; i++){
            IComponent component = components.get(keys[i]);
            component.getSystem().deleteComponent(this);
        }
        components.clear();
        EntityGod.ins.entities.remove(this);
    }
}
