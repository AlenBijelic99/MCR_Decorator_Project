package com.decorator.game.objects.equipment;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public class EquipmentDecorator implements Equipment {
    private Equipment equipment;

    public EquipmentDecorator(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String getDescription() {
        return equipment.getDescription();
    }

    @Override
    public int addPower() {
        return equipment.addPower();
    }

    @Override
    public float addSpeed() {
        return equipment.addSpeed();
    }

    @Override
    public float addJump() {
        return equipment.addJump();
    }

    @Override
    public int addDefense() {
        return equipment.addDefense();
    }

}
