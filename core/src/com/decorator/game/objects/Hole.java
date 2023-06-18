package com.decorator.game.objects;


import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.player.StaticGameEntity;

/**
 * Represents a hole.
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class Hole extends StaticGameEntity {

    /**
     * Constructor with arguments.
     * @param x x coordinate
     * @param y y coordinate
     * @param width width of the hole
     * @param height height of the hole
     * @param body body of the hole
     */
    public Hole(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

    @Override
    public String getImagePath() {
        return "assets/deserttileset/png/Objects/killerBush.png";
    }

    @Override
    public void update() {

    }

}
