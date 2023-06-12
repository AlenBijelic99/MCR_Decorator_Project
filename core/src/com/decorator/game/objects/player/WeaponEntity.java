package com.decorator.game.objects.player;

import com.badlogic.gdx.physics.box2d.Body;

public abstract class WeaponEntity extends StaticGameEntity {

    public WeaponEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

}
