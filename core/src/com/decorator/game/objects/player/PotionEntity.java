package com.decorator.game.objects.player;

import com.badlogic.gdx.physics.box2d.Body;

public abstract class PotionEntity extends StaticGameEntity {
    public PotionEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }
}
