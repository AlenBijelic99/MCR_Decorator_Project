package com.decorator.game.objects.equipment.armor;

import com.decorator.game.objects.equipment.Equipment;

import static com.decorator.game.utils.Constants.GOLD_ARMOR_DEFENSE;

/**
 * Represents Gold Armor class
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class GoldArmor extends Armor {
    /**
     * Constructor
     *
     * @param equipment Equipment
     */
    public GoldArmor(Equipment equipment) {
        super(equipment);
    }

    /**
     * Returns the description of the armor
     *
     * @return String describing the armor
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " ,Gold Armor";
    }

    /**
     * Adds the defense of the armor
     *
     * @return int representing the defense of the armor
     */
    @Override
    public int addDefense() {
        return super.addDefense() + GOLD_ARMOR_DEFENSE;
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
     * Returns the name of the armor
     * @return String representing the name of the armor
     */
    @Override
    public String toString() {
        return "Gold";
    }
}
