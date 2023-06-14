package com.decorator.game.objects.equipment.armor;

import com.decorator.game.objects.equipment.Equipment;

import static com.decorator.game.utils.Constants.GOLD_ARMOR_DEFENSE;

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
        return super.addDefense() + GOLD_ARMOR_DEFENSE;
    }

    @Override
    public String toString() {
        return "Gold";
    }
}
