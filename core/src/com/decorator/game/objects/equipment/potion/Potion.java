package com.decorator.game.objects.equipment.potion;

import com.decorator.game.objects.equipment.Equipment;
import com.decorator.game.objects.equipment.EquipmentDecorator;

public class Potion extends EquipmentDecorator {
    public Potion(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", " + this.getClass().getSimpleName();
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
