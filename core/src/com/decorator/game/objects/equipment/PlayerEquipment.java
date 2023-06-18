package com.decorator.game.objects.equipment;

import com.decorator.game.utils.Constants;

/**
 * Represents the player's equipment.
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class PlayerEquipment implements Equipment {
    /**
     * Returns the description of the player's equipment.
     *
     * @return String represent the description of the equipment
     */

    @Override
    public String getDescription() {
        return "Player equipment";
    }

    /**
     * Returns the strength of the basic player's equipment.
     *
     * @return int represent the strength of the equipment
     */
    @Override
    public int addStrength() {
        return 10;
    }

    /**
     * Returns the speed of the player's equipment.
     *
     * @return float represent the speed of the equipment
     */
    @Override
    public float addSpeed() {
        return Constants.PLAYER_SPEED;
    }

    /**
     * Returns the jumping capacity of the player's equipment.
     *
     * @return float represent the jumping capacity of the equipment
     */
    @Override
    public float addJump() {
        return Constants.MAX_JUMPING_HEIGHT;
    }

    /**
     * Returns the defense of the player's equipment.
     *
     * @return int represent the defense of the equipment
     */
    @Override
    public int addDefense() {
        return 0;
    }

    /**
     * Sets the equipment, but there is no equipment to set since it is the basic player's equipment.
     *
     * @param equipment equipment
     */
    @Override
    public void setEquipment(Equipment equipment) {
        System.out.println("No equipment to set");
    }

    /**
     * Returns the equipment.
     *
     * @return Equipment basic player's equipment
     */
    @Override
    public Equipment getEquipment() {
        return this;
    }

    /**
     * Removes the equipment, but there is no equipment to remove since it is the basic player's equipment.
     *
     * @param c class of the equipment to remove
     * @return Equipment basic player's equipment
     */
    @Override
    public Equipment removeEquipment(Class<Equipment> c) {
        System.out.println("No equipment to remove");
        return this;
    }

    /**
     * Returns the name of the player's equipment.
     *
     * @return String represent the name of the equipment
     */
    @Override
    public String toString() {
        return "Player equipment";
    }
}
