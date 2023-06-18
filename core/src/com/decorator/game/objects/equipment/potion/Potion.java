package com.decorator.game.objects.equipment.potion;

import com.decorator.game.objects.equipment.Equipment;
import com.decorator.game.objects.equipment.EquipmentDecorator;

/**
 * Represents a Potion Decorator
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class Potion extends EquipmentDecorator {
    /**
     * Constructor of the Potion
     * @param equipment The equipment to decorate it with a Potion
     */
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
