package com.decorator.game.objects.equipment.armor;

import com.decorator.game.objects.equipment.Equipment;
import com.decorator.game.objects.equipment.EquipmentDecorator;

/**
 * Armor class that represents the different armors of the player
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public abstract class Armor extends EquipmentDecorator {
    /**
     * Constructor
     *
     * @param equipment Equipment
     */
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


}
