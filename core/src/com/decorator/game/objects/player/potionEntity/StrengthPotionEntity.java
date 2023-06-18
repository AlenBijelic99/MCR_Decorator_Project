package com.decorator.game.objects.player.potionEntity;

import com.badlogic.gdx.physics.box2d.Body;

/**
 * Represents a Strength Potion Entity
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class StrengthPotionEntity extends PotionEntity {
    /**
     * Constructor of StrengthPotionEntity
     * @param x         x coordinate to place the potion
     * @param y         y coordinate to place the potion
     * @param width     Width of the potion
     * @param height    Height of the potion
     * @param body      Body of the potion
     */
    public StrengthPotionEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

    @Override
    public String getImagePath() {
        return "kenney_tiny-dungeon/Potions/tile_0115.png";
    }
}
