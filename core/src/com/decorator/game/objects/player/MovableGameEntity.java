package com.decorator.game.objects.player;

import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.GameEntity;

/**
 * Represents a movable game entity.
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */

public abstract class MovableGameEntity extends GameEntity {
    protected float dx, dy, speed;

    /**
     * Constructor with arguments.
     * @param width  width of the entity
     * @param height height of the entity
     * @param body  body of the entity
     */
    public MovableGameEntity(float width, float height, Body body) {
        super(width, height, body);
        dx = 0;
        dy = 0;
        speed = 0;
    }

}
