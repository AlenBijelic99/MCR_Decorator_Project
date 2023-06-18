package com.decorator.game.objects.equipment.potion;

import com.decorator.game.objects.equipment.Equipment;

/**
 * Represents a Strength Potion Decorator
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class StrengthPotion extends Potion {

    /**
     * How much strength the potion will increase
     */
    private static final int STRENGTH_INCREASE = 10;

    /**
     * Constructor of the Strength Potion
     * @param equipment The equipment to decorate it with a Strength Potion
     */
    public StrengthPotion(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Strength Potion";
    }



    @Override
    public int addStrength() {
        return super.addStrength() + STRENGTH_INCREASE;
    }

}
