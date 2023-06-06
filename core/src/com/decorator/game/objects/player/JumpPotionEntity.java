package com.decorator.game.objects.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public class JumpPotionEntity extends PotionEntity {

    public JumpPotionEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

    @Override
    public String getImagePath() {
        return "kenney_tiny-dungeon/Potions/tile_0114.png";
    }
}
