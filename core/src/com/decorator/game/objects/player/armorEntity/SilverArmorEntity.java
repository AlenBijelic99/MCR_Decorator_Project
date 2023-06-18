package com.decorator.game.objects.player.armorEntity;

import com.badlogic.gdx.physics.box2d.Body;

/**
 * Represents a silver armor entity.
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class SilverArmorEntity extends ArmorEntity {
    /**
     * Constructor with arguments.
     *
     * @param x      x coordinate
     * @param y      y coordinate
     * @param width  width
     * @param height height
     * @param body   body
     */
    public SilverArmorEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

    /**
     * Get image path.
     *
     * @return image path
     */
    @Override
    public String getImagePath() {
        return "assets/armor/silver.png";

    }
}
