package com.decorator.game.objects.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.utils.Constants;

public class Enemy extends MovableGameEntity {

    public Enemy(float width, float height, Body body) {
        super(width, height, body);
    }

    @Override
    public void update() {
        x = body.getPosition().x * Constants.PPM;
        y = body.getPosition().y * Constants.PPM;
    }

    @Override
    public void render(SpriteBatch batch) {
        //TODO change by enemy sprite for the image and change region by frame once enemy emplemented
        batch.begin();
        TextureRegion region = new TextureRegion(new Texture("assets/player/idle/Player_Dagger_Bronze_0.png"));
        batch.draw(region, x - width / 2, y - height / 2, region.getRegionWidth() * 2, region.getRegionHeight() * 2);
        batch.end();

    }
}
