package com.decorator.game.objects.equipment.armor;

import com.decorator.game.objects.equipment.Equipment;

public class SilverArmor extends Armor {
    public SilverArmor(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }

    @Override
    public int addDefense() {
        return super.addDefense() + 10;
    }

    @Override
    public String toString() {
        return "Silver";
    }
}
