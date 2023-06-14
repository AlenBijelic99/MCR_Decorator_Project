package com.decorator.game.objects.equipment.weapon;

import com.decorator.game.objects.equipment.Equipment;
import com.decorator.game.objects.equipment.EquipmentDecorator;

public class Weapon extends EquipmentDecorator {
    public Weapon(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String toString() {
        return "None";
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
