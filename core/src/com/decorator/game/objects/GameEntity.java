package com.decorator.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Represents a game entity.
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public abstract class GameEntity {
    protected float x, y, width, height;
    protected Body body;

    /**
     * Constructor with arguments.
     *
     * @param width  width of the entity
     * @param height height of the entity
     * @param body   body of the entity
     */
    public GameEntity(float width, float height, Body body) {
        x = body.getPosition().x;
        y = body.getPosition().y;
        this.width = width;
        this.height = height;
        this.body = body;
    }

    public abstract void update();

    public abstract void render(SpriteBatch batch);

    public Body getBody() {
        return body;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
