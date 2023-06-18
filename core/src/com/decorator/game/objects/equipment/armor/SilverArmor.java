package com.decorator.game.objects.equipment.armor;

import com.decorator.game.objects.equipment.Equipment;

import static com.decorator.game.utils.Constants.SILVER_ARMOR_DEFENSE;

/**
 * Represents Silver Armor class
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
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
        return SILVER_ARMOR_DEFENSE;
    }


    @Override
    public String toString() {
        return "Silver";
    }

}
