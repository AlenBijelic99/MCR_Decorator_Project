package com.decorator.game.objects.door;

import com.badlogic.gdx.physics.box2d.Body;

public class DoorLocked extends Door {

    public DoorLocked(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

    @Override
    public boolean isUnlocked() {
        return false;
    }

    @Override
    public String getImagePath() {
        return "kenney_tiny-dungeon/Door/tile_0045.png";
    }
}
