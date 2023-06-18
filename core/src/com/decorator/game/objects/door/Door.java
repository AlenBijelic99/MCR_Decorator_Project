package com.decorator.game.objects.door;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.GameEntity;

/**
 * Represents a Door entity
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public abstract class Door extends GameEntity {

    /**
     * Constructor of Door
     * @param x         x coordinate to place the door
     * @param y         y coordinate to place the door
     * @param width     Width of the door
     * @param height    Height of the door
     * @param body      Body of the door
     */
    public Door(float x, float y, float width, float height, Body body) {
        super(width, height, body);
        this.x = x;
        this.y = y;
    }

    /**
     * @return true if the door is unlocked, false if it isn't
     */
    public abstract boolean isUnlocked();

    @Override
    public void update() {
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        String s = getImagePath();
        TextureRegion region = new TextureRegion(new Texture(getImagePath()));
        batch.draw(region, x - region.getRegionWidth(), y, region.getRegionWidth() * 4, region.getRegionHeight() * 4);
        batch.end();
    }

    /**
     * @return the image path of the door to display
     */
    public abstract String getImagePath();
}
