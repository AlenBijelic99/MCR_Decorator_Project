package com.decorator.game.objects.player.potionEntity;

import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.player.StaticGameEntity;

public abstract class PotionEntity extends StaticGameEntity {
    public PotionEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }
}
