package com.decorator.game.objects.player;

import com.badlogic.gdx.physics.box2d.Body;

public class StrengthPotionEntity extends PotionEntity {
    public StrengthPotionEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

    @Override
    public String getImagePath() {
        return "kenney_tiny-dungeon/Potions/tile_0115.png";
    }
}
