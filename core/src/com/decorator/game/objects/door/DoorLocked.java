package com.decorator.game.objects.door;

import com.badlogic.gdx.physics.box2d.Body;

/**
 * Represents a Locked Door
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class DoorLocked extends Door {

    /**
     * Constructor of DoorLocked
     * @param x         x coordinate to place the door
     * @param y         y coordinate to place the door
     * @param width     Width of the door
     * @param height    Height of the door
     * @param body      Body of the door
     */
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
