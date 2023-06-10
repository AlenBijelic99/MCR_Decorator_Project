package com.decorator.game.objects.player;

import com.badlogic.gdx.physics.box2d.Body;

public class PunchEntity extends WeaponEntity {
    public PunchEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

    @Override
    public String getImagePath() {
        return "kenney_tiny-dungeon/Weapons/tile_0130.png";
    }
}
