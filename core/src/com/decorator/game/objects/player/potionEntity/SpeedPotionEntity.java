package com.decorator.game.objects.player.potionEntity;

import com.badlogic.gdx.physics.box2d.Body;

public class SpeedPotionEntity extends PotionEntity {

    public SpeedPotionEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

    @Override
    public String getImagePath() {
        return "kenney_tiny-dungeon/Potions/tile_0116.png";
    }
}
