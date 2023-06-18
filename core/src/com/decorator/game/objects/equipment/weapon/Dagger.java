package com.decorator.game.objects.equipment.weapon;

import com.decorator.game.objects.equipment.Equipment;

import static com.decorator.game.utils.Constants.DAGGER_DAMAGE;

/**
 * Represents Dagger class
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */

public class Dagger extends Weapon {
    /**
     * Constructor
     *
     * @param equipment Equipment
     */
    public Dagger(Equipment equipment) {
        super(equipment);
    }

    /**
     * Returns the description of the weapon
     *
     * @return String describing the weapon
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " ,Dagger";
    }

    /**
     * Adds the strength of the weapon
     *
     * @return int representing the strength of the weapon
     */
    @Override
    public int addStrength() {
        return super.addStrength() + DAGGER_DAMAGE;
    }

    /**
     * Sets the equipment
     * @param equipment Equipment
     */
    @Override
    public void setEquipment(Equipment equipment) {
        super.setEquipment(equipment);
    }

    /**
     * Returns the equipment
     * @return Equipment
     */
    @Override
    public Equipment getEquipment() {
        return super.getEquipment();
    }

    /**
     * Returns the name of the weapon
     *
     * @return String representing the name of the weapon
     */
    @Override
    public String toString() {
        return "Dagger";
    }
}
