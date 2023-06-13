package com.decorator.game.objects.player.weaponEntity;

import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.player.StaticGameEntity;

public abstract class WeaponEntity extends StaticGameEntity {

    public WeaponEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

}
