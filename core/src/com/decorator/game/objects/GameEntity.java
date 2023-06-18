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
    protected Body body; // The body of the GameEntity

    /**
     * Constructor
     *
     * @param width  The width of the Entity
     * @param height The Height of the Entity
     * @param body   The Body of the Entity
     */
    public GameEntity(float width, float height, Body body) {
        x = body.getPosition().x;
        y = body.getPosition().y;
        this.width = width;
        this.height = height;
        this.body = body;
    }

    /**
     * Updates the entity
     */
    public abstract void update();

    /**
     * Render the Entity's sprite
     *
     * @param batch The sprite batch of the entity
     */
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
