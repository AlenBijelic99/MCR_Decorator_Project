package com.decorator.game.objects.door;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.GameEntity;

/**
 * Represents a key
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class Key extends GameEntity {

    /**
     * Constructor of key
     * @param x         x coordinate to place the door
     * @param y         y coordinate to place the door
     * @param width     Width of the door
     * @param height    Height of the door
     * @param body      Body of the door
     */
    public Key(float x, float y, float width, float height, Body body) {
        super(width, height, body);
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        TextureRegion region = new TextureRegion(new Texture("kenney_tiny-town/Key/tile_0117.png"));
        batch.draw(region, x + 5, y, region.getRegionWidth(), region.getRegionHeight());
        batch.end();
    }
}
