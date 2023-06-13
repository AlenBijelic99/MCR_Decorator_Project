package com.decorator.game.objects.equipment.potion;

import com.decorator.game.objects.equipment.Equipment;

public class StrengthPotion extends Potion {

    private static final int STRENGTH_INCREASE = 10;

    public StrengthPotion(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Strength Potion";
    }

    @Override
    public int addStrength() {
        return super.addStrength() + STRENGTH_INCREASE;
    }
}
