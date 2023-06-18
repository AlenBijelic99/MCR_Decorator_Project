package com.decorator.game.objects.equipment.potion;

import com.decorator.game.objects.equipment.Equipment;

public class SpeedPotion extends Potion {
    private static final float SPEED_MULTIPLIER = 1.2F;

    public SpeedPotion(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Speed Potion";
    }

    @Override
    public float addSpeed() {
        return super.addSpeed() * SPEED_MULTIPLIER;
    }

    @Override
    public void setEquipment(Equipment equipment) {
        super.setEquipment(equipment);
    }

    @Override
    public Equipment getEquipment() {
        return super.getEquipment();
    }
}
