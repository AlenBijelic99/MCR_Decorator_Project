package com.decorator.game.objects.equipment.weapon;

import com.decorator.game.objects.equipment.Equipment;

import static com.decorator.game.utils.Constants.LONG_SWORD_DAMAGE;

/**
 * Represents LongSword class
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */

public class LongSword extends Weapon {
    public LongSword(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }

    @Override
    public int addStrength() {
        return  LONG_SWORD_DAMAGE;
    }


    @Override
    public String toString() {
        return "LSword";
    }

}