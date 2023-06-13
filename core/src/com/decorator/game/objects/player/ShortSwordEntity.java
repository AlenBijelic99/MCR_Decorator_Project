package com.decorator.game.objects.player;

import com.badlogic.gdx.physics.box2d.Body;

public class ShortSwordEntity extends WeaponEntity{
       public ShortSwordEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }
    @Override
    public String getImagePath() {
        return "assets/weapons/Dagger.png";
    }

}
