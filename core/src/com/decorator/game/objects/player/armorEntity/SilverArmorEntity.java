package com.decorator.game.objects.player.armorEntity;

import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.player.armorEntity.ArmorEntity;

public class SilverArmorEntity extends ArmorEntity {
    public SilverArmorEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

    @Override
    public String getImagePath() {
        return "assets/armor/silver.png";

    }
}
