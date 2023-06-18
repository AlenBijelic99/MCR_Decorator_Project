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
     * Returns the name of the weapon
     *
     * @return String representing the name of the weapon
     */
    @Override
    public String toString() {
        return "Dagger";
    }

    @Override
    public int addStrength() {
         return  DAGGER_DAMAGE;
    }



}
