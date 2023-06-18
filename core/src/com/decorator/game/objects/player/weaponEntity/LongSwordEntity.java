package com.decorator.game.objects.player.weaponEntity;

import com.badlogic.gdx.physics.box2d.Body;

/**
 * Represents a long sword entity.
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class LongSwordEntity extends WeaponEntity {
    /**
     * Constructor that creates a long sword entity.
     *
     * @param x      x coordinate
     * @param y      y coordinate
     * @param width  width
     * @param height height
     * @param body   body
     */
    public LongSwordEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

    /**
     * Returns the image path of the long sword entity.
     *
     * @return image path
     */
    @Override
    public String getImagePath() {
        return "weapons/LSword.png";

    }
}
