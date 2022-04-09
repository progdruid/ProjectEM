package com.projectem.game.ecs;

import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;
import java.util.List;

public class EntityGod implements Disposable {
    public static EntityGod ins;
    public static void init () {ins = new EntityGod();}

    public List<Entity> entities;

    public EntityGod () {
        entities = new ArrayList<>();
    }

    public void dispose () {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).dispose();
        }
        EntityGod.ins = null;
    }
}
