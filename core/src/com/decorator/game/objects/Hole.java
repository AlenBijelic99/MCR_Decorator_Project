package com.decorator.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public class Hole extends GameEntity{

    public Hole(float x, float y, float width, float height, Body body) {
        super( width, height, body);
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(SpriteBatch batch) {

    }
}
