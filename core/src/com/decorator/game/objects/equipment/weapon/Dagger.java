package com.decorator.game.objects.equipment.weapon;

import com.decorator.game.objects.equipment.Equipment;

public class Dagger extends Weapon{
    public Dagger(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }

    @Override
    public int addStrength() {
        return super.addStrength() + 50;
    }

    @Override
    public String toString() {
        return "Dagger";
    }
}
