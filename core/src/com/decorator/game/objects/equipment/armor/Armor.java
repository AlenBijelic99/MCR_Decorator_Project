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
    public void removeEquipment(Class<Equipment> equipmentClass) {
        if (this.getEquipment().getClass() == equipmentClass) {
            setEquipment(this.getEquipment());
        } else {
            getEquipment().removeEquipment(equipmentClass);
        }
    }

    @Override
    public Equipment getEquipment() {
        return super.getEquipment();
    }
}
