package com.decorator.game.objects.equipment.weapon;

import com.decorator.game.objects.equipment.Equipment;

import static com.decorator.game.utils.Constants.LONG_SWORD_DAMAGE;

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
        return LONG_SWORD_DAMAGE;
    }

    @Override
    public String toString() {
        return "LSword";
    }
}
