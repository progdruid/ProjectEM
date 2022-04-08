package com.projectem.game.ecs;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Entity {
    //region Fields
    private String name;
    private int x, y;
    private float scaleX, scaleY;
    private float rot;

    private List<IComponent> components;
    //endregion
    //region Constructors
    public Entity (String name) {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.scaleX = 1;
        this.scaleY = 1;
        this.rot = 0;

        this.components = new ArrayList<>();
    }

    public Entity (String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.scaleX = 1;
        this.scaleY = 1;
        this.rot = 0;

        this.components = new ArrayList<>();
    }

    public Entity (String name, int x, int y, int scaleX, int scaleY, float rot) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.rot = rot;

        this.components = new ArrayList<>();
    }

    public Entity (String name, int x, int y, float rot) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.scaleX = 1;
        this.scaleY = 1;
        this.rot = rot;

        this.components = new ArrayList<>();
    }
    //endregion
    //region Mutation
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public float getRot() {
        return rot;
    }
    public void setRot(float rot) {
        this.rot = rot;
    }

    public float getScaleX() {
        return scaleX;
    }
    public float getScaleY() {
        return scaleY;
    }
    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }
    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
    }

    public void translate (int byX, int byY) {
        this.x += byX; this.y = byY;
    }
    public void rotate (float angle) {
        this.rot += angle;
    }
    public void changeScale (float byX, float byY){
        this.scaleX += byX;
        this.scaleY += byY;
    }

    //endregion
    //region Components
    public void appendComponent (IComponent component) {
        this.components.add(component);
    }

    public void removeComponent (IComponent component) {
        this.components.remove(component);
    }

    public IComponent getComponent (String name) {
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getClass().getSimpleName() == name)
                return components.get(i);
        }
        throw new NoSuchElementException("There is no such component");
    }
    //endregion
}
