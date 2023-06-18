package com.decorator.game.objects.equipment.armor;

import com.decorator.game.objects.equipment.Equipment;
import com.decorator.game.objects.equipment.EquipmentDecorator;

public class Armor extends EquipmentDecorator {
    public Armor(Equipment equipment) {
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

    @Override
    public void setEquipment(Equipment equipment) {
        super.setEquipment(equipment);
    }

    @Override
    public Equipment getEquipment() {
        return super.getEquipment();
    }

    @Override
    public Equipment removeEquipment(Class<Equipment> c) {
        if (equipment.getClass() == c) {
            System.out.println("Removing " + equipment.getClass().getSimpleName());
            equipment = equipment.getEquipment();
        } else if (equipment instanceof EquipmentDecorator) {
            equipment.removeEquipment(c);
        }
        return equipment;
    }
}
