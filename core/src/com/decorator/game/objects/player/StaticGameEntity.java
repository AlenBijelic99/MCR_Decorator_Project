package com.decorator.game.objects.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.GameEntity;

/**
 * Represents a static game entity.
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public abstract class StaticGameEntity extends GameEntity {
    /**
     * Constructor with arguments.
     * @param x x coordinate
     * @param y y coordinate
     * @param width width of the entity
     * @param height height of the entity
     * @param body body of the entity
     */
    public StaticGameEntity(float x, float y, float width, float height, Body body) {
        super(width, height, body);
        this.x = x;
        this.y = y;
    }

    public abstract String getImagePath();

    @Override
    public void update() {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        TextureRegion region = new TextureRegion(new Texture(getImagePath()));
        batch.draw(region, x - 10, y, region.getRegionWidth() * 4, region.getRegionHeight() * 4);
        batch.end();

    }
}
