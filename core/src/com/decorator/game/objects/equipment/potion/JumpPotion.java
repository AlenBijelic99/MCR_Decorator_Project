package com.decorator.game.objects.equipment.potion;

import com.decorator.game.objects.equipment.Equipment;

/**
 * Represents a Jump Potion Decorator
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class JumpPotion extends Potion {
    /**
     * The multiplier that the jump potion will apply
     */
    private static final float JUMP_MULTIPLIER = 15F;

    /**
     * Constructor of the JumpPotion
     * @param equipment The equipment to decorate it with a Jump Potion
     */
    public JumpPotion(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Jump Potion";
    }

    @Override
    public float addJump() {
        return super.addJump() * JUMP_MULTIPLIER;
    }

    @Override
    public void setEquipment(Equipment equipment) {
        super.setEquipment(equipment);
    }

    @Override
    public Equipment getEquipment() {
        return super.getEquipment();
    }
}
