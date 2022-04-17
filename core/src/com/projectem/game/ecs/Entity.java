package com.projectem.game.ecs;

import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Entity implements Disposable {

    public String name = "";

    private List<Entity> children;
    public Entity parent;

    public HashMap<String, IComponent> components;
    public TransformComponent transform;

    public Entity (String name) {
        EntityGod.ins.entities.add(this);
        this.name = name;
        this.children = new ArrayList<>();
        this.components = new HashMap<>();
        this.transform = (TransformComponent) TransformSystem.ins.createComponent(this);
    }

    public int getChildrenCount () {
        return children.size();
    }

    public Entity getChild (int index) {
        return children.get(index);
    }

    public void addChild (Entity child) {
        children.add(child);
        child.parent = this;
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
