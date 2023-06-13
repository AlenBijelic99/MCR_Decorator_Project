package com.decorator.game.objects.player.armorEntity;

import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.objects.player.armorEntity.ArmorEntity;

public class BronzeArmorEntity extends ArmorEntity {
    public BronzeArmorEntity(float x, float y, float width, float height, Body body) {
        super(x, y, width, height, body);
    }

    @Override
    public String getImagePath() {
        return "assets/armor/bronze.png";
    }
}
