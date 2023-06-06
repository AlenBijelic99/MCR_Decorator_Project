package com.decorator.game.objects.equipment;

public class JumpPotion extends Potion {
    private static final float JUMP_MULTIPLIER = 1.5F;

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
}
