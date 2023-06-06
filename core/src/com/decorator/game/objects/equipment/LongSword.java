package com.decorator.game.objects.equipment;

public class LongSword extends Weapon {
    public LongSword(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }

    @Override
    public int addPower() {
        return super.addPower() + 100;
    }


}
