package com.projectem.game.ecs;

public interface IComponent {
    public Entity getEntity ();
    public ISystem getSystem ();
}
