package com.decorator.game.objects.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.GameEntity;

public abstract class PotionEntity extends GameEntity {
    public PotionEntity(float x, float y, float width, float height, Body body) {
        super(width, height, body);
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {
        body.destroyFixture(body.getFixtureList().first());
        body = null;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        String s = getImagePath();
        TextureRegion region = new TextureRegion(new Texture(getImagePath()));
        batch.draw(region, x - 10, y, region.getRegionWidth() * 4, region.getRegionHeight() * 4);
        batch.end();
    }

    public abstract String getImagePath();
}
