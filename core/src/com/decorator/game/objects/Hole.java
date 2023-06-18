package com.decorator.game.objects;


import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.player.StaticGameEntity;

public class Hole extends StaticGameEntity {

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
