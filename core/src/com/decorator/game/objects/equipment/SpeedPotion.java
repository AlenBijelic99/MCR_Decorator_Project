package com.decorator.game.objects.equipment;

public class SpeedPotion extends Potion {
    private static final float SPEED_MULTIPLIER = 1.5F;

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
