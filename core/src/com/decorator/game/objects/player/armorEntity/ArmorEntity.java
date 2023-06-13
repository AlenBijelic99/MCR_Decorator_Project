package com.decorator.game.objects.player.armorEntity;

import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.player.StaticGameEntity;

public abstract class ArmorEntity extends StaticGameEntity {

    public ArmorEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

}
