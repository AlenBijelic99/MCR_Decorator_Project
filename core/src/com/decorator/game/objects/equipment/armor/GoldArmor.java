package com.decorator.game.objects.equipment.armor;

import com.decorator.game.objects.equipment.Equipment;

public class GoldArmor extends Armor{
    public GoldArmor(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }

    @Override
    public int addDefense() {
        return super.addDefense() + 50;
    }

    @Override
    public String toString() {
        return "Gold";
    }
}
