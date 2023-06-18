package com.decorator.game.objects.equipment.potion;

import com.decorator.game.objects.equipment.Equipment;
import com.decorator.game.objects.equipment.EquipmentDecorator;
import com.decorator.game.objects.equipment.PlayerEquipment;

public abstract class Potion extends EquipmentDecorator {
    public Potion(Equipment equipment) {
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
