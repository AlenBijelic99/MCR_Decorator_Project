package com.decorator.game.objects.player.potionEntity;

import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.player.StaticGameEntity;

/**
 * Represents a Potion Entity
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public abstract class PotionEntity extends StaticGameEntity {
    /**
     * Constructor of PotionEntity
     * @param x         x coordinate to place the potion
     * @param y         y coordinate to place the potion
     * @param width     Width of the potion
     * @param height    Height of the potion
     * @param body      Body of the potion
     */
    public PotionEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }
}
