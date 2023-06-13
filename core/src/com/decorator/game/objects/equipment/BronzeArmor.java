package com.decorator.game.objects.equipment;

public class BronzeArmor extends Armor {
    public BronzeArmor(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }

    @Override
    public int addDefense() {
        return super.addDefense() + 10;
    }
}
