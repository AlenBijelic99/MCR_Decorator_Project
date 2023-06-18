package com.decorator.game.objects.player.armorEntity;

import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.player.StaticGameEntity;

/**
 * Represents an armor entity.
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */

public abstract class ArmorEntity extends StaticGameEntity {
    /**
     * Constructor with arguments.
     *
     * @param x      x coordinate
     * @param y      y coordinate
     * @param width  width
     * @param height height
     * @param body   body
     */

    public ArmorEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

}
