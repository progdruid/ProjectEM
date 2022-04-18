package com.projectem.game.ecs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public class CellComponent implements IComponent {

    private final Entity entity;

    public List<CellComponent> connectedCells;

    public final Texture selectedRingTexture;

    public CellComponent (Entity entity) {
        this.entity = entity;
        this.connectedCells = new ArrayList<>();
        this.selectedRingTexture = new Texture(Gdx.files.internal("badlogic.jpg"));
    }

    public void addConnected (CellComponent cell) {
        connectedCells.add(cell);
        cell.connectedCells.add(this);
    }

    public void removeConnected (CellComponent cell) {
        connectedCells.remove(cell);
        cell.connectedCells.remove(this);
    }

    public void clearConnected () {
        for (CellComponent cell : connectedCells) {
            cell.connectedCells.remove(this);
        }

        connectedCells.clear();
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    @Override
    public IComponentSystem getSystem() {
        return CellSystem.ins;
    }
}
