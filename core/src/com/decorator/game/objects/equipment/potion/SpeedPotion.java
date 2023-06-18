package com.decorator.game.objects.equipment.potion;

import com.decorator.game.objects.equipment.Equipment;

/**
 * Represents a Speed Potion Decorator
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class SpeedPotion extends Potion {
    /**
     * The multiplier that the speed potion will apply
     */
    private static final float SPEED_MULTIPLIER = 1.2F;

    /**
     * Constructor of the Speed Potion
     * @param equipment The equipment to decorate it with a Speed Potion
     */
    public SpeedPotion(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Speed Potion";
    }


    @Override
    public float addSpeed() {
        return super.addSpeed() * SPEED_MULTIPLIER;
    }

}
