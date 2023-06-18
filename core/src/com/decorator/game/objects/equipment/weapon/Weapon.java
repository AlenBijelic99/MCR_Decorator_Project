package com.decorator.game.objects.equipment.weapon;

import com.decorator.game.objects.equipment.Equipment;
import com.decorator.game.objects.equipment.EquipmentDecorator;
import com.decorator.game.objects.equipment.PlayerEquipment;

public abstract class Weapon extends EquipmentDecorator {
    public Weapon(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }


    @Override
    public String toString() {
        return "None";
    }

}
