package com.decorator.game.objects.equipment.weapon;

import com.decorator.game.objects.equipment.Equipment;

import static com.decorator.game.utils.Constants.DAGGER_DAMAGE;

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
        return super.addStrength() + DAGGER_DAMAGE;
    }

    @Override
    public String toString() {
        return "Dagger";
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
