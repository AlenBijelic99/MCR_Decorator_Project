package com.decorator.game.objects.equipment.armor;

import com.decorator.game.objects.equipment.Equipment;

import static com.decorator.game.utils.Constants.SILVER_ARMOR_DEFENSE;

/**
 * Represents Silver Armor class
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 */

public class SilverArmor extends Armor {
    /**
     * Constructor
     * @param equipment Equipment
     */
    public SilverArmor(Equipment equipment) {
        super(equipment);
    }

    /**
     * Returns the description of the armor
     * @return String describing the armor
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " ,Silver Armor";
    }

    /**
     * Adds the defense of the armor
     * @return int representing the defense of the armor
     */
    @Override
    public int addDefense() {
        return super.addDefense() + SILVER_ARMOR_DEFENSE;
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
     * Returns the name of the armor
     * @return String representing the name of the armor
     */
    @Override
    public String toString() {
        return "Silver";
    }

}
