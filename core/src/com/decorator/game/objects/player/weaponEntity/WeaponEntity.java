package com.decorator.game.objects.player.weaponEntity;

import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.player.StaticGameEntity;

/**
 * Represents a weapon entity.
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */

public abstract class WeaponEntity extends StaticGameEntity {
    /**
     * Constructor that creates a weapon entity.
     *
     * @param x      x coordinate
     * @param y      y coordinate
     * @param width  width
     * @param height height
     * @param body   body
     */

    public WeaponEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

}
