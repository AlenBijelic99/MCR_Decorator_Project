package com.decorator.game.objects.equipment;

/**
 * Represents an equipment.
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public interface Equipment {
    /**
     * Returns the name of the equipment.
     *
     * @return String represent the name of the equipment
     */
    String toString();

    /**
     * Returns the description of the equipment.
     *
     * @return String represent the description of the equipment
     */
    String getDescription();

    /**
     * Returns the strength of the equipment.
     *
     * @return int represent the strength of the equipment
     */
    int addStrength();

    /**
     * Returns the speed of the equipment.
     *
     * @return float represent the speed of the equipment
     */
    float addSpeed();

    /**
     * Returns the jumping capacity of the equipment.
     *
     * @return float represent the jumping capacity of the equipment
     */
    float addJump();

    /**
     * Returns the defense of the equipment.
     *
     * @return int represent the defense of the equipment
     */
    int addDefense();

    /**
     * Sets the equipment.
     *
     * @param equipment equipment
     */
    void setEquipment(Equipment equipment);

    /**
     * Returns the equipment.
     *
     * @return Equipment
     */
    Equipment getEquipment();

    /**
     * Removes the equipment.
     *
     * @param c class of the equipment to remove
     * @return Equipment
     */

    void removeEquipment(Class<Equipment> c);
}
