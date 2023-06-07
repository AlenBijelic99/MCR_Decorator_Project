package com.decorator.game.objects.door;

import com.badlogic.gdx.physics.box2d.Body;

public class DoorUnlocked extends Door {
    public DoorUnlocked(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

    @Override
    public String getImagePath() {
        return "kenney_tiny-dungeon/Door/tile_0021.png";
    }
}
