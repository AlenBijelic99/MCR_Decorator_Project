package com.decorator.game.objects.equipment.weapon;

import com.decorator.game.objects.equipment.Equipment;
import com.decorator.game.objects.equipment.EquipmentDecorator;

/**
 * Represents Weapon class
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */

public class Weapon extends EquipmentDecorator {
    /**
     * Constructor
     *
     * @param equipment Equipment
     */
    public Weapon(Equipment equipment) {
        super(equipment);
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
     */
    @Override
    public void removeEquipment(Class<Equipment> c) {
        if (equipment.getClass() == c) {
            System.out.println("Removing " + equipment.getClass().getSimpleName());
            equipment = equipment.getEquipment();
        } else if (equipment instanceof EquipmentDecorator) {
            equipment.removeEquipment(c);
        }
    }

    /**
     * Returns the name of the weapon
     *
     * @return String representing the name of the weapon, None because it's the base class
     */
    @Override
    public String toString() {
        return "None";
    }
}
