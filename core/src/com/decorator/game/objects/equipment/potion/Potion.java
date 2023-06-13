package com.decorator.game.objects.equipment.potion;

import com.decorator.game.objects.equipment.Equipment;
import com.decorator.game.objects.equipment.EquipmentDecorator;

public class Potion extends EquipmentDecorator {
    public Potion(Equipment equipment) {
        super(equipment);
    }
}
