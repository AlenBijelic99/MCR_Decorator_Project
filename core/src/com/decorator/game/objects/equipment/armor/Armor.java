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
public class Armor extends EquipmentDecorator {
    /**
     * Constructor
     *
     * @param equipment Equipment
     */
    public Armor(Equipment equipment) {
        super(equipment);
    }


    /**
     * Returns the description of the armor
     *
     * @return String describing the armor
     */
    @Override
    public String getDescription() {
        return super.getDescription() + ", " + this.getClass().getSimpleName();
    }


    /**
     * Sets the equipment
     *
     * @param equipment Equipment
     */
    @Override
    public void setEquipment(Equipment equipment) {
        super.setEquipment(equipment);
    }

    /**
     * Returns the equipment
     *
     * @return Equipment
     */
    @Override
    public Equipment getEquipment() {
        return super.getEquipment();
    }

    /**
     * Removes the equipment
     *
     * @param c Class of the equipment to remove
     * @return Equipment after eventual removing of the equipment
     */
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

    /**
     * Returns the name of the armor
     * @return none since this is the base class
     */
    @Override
    public String toString() {
        return "None";
    }
}
