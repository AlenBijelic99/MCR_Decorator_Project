package com.decorator.game.objects.player;

import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.GameEntity;

public abstract class MovableGameEntity extends GameEntity {
    protected float dx, dy, speed;

    public MovableGameEntity(float width, float height, Body body) {
        super(width, height, body);
        dx = 0;
        dy = 0;
        speed = 0;
    }
}
