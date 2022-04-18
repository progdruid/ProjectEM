package com.projectem.game.ecs;

import java.util.ArrayList;
import java.util.List;

public class CellSystem implements IComponentSystem{

    //region static
    public static CellSystem ins;
    public static void init () {
        ins = new CellSystem();
    }
    //endregion

    private List<CellComponent> cells;

    public CellSystem () {
        cells = new ArrayList<>();
    }

    @Override
    public void update() {

    }

    @Override
    public IComponent createComponent(Entity entity) {
        CellComponent cell = new CellComponent(entity);
        entity.components.put(cell.getClass().getSimpleName(), cell);
        cells.add(cell);
        return cell;
    }

    @Override
    public void deleteComponent(Entity entity) {
        CellComponent cell = (CellComponent) entity.components.get("CellComponent");
        entity.components.remove("CellComponent");
        cells.remove(cell);

        cell.clearConnected();
    }

    @Override
    public void dispose() {

    }
}
