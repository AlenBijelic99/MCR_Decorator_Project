package com.decorator.game.objects.door;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.GameEntity;

public abstract class Door extends GameEntity {

    public Door(float x, float y, float width, float height, Body body) {
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
        String s = getImagePath();
        TextureRegion region = new TextureRegion(new Texture(getImagePath()));
        batch.draw(region, x - region.getRegionWidth(), y, region.getRegionWidth() * 4, region.getRegionHeight() * 4);
        batch.end();
    }

    public abstract String getImagePath();

}
