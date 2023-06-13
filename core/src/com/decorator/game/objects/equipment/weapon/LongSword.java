package com.decorator.game.objects.equipment.weapon;

import com.decorator.game.objects.equipment.Equipment;

public class LongSword extends Weapon {
    public LongSword(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }

    @Override
    public int addStrength() {
        return super.addStrength() + 100;
    }

    @Override
    public String toString() {
        return "LSword";
    }
}
