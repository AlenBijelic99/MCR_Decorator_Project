package com.decorator.game.objects.equipment;

public class UltimateArmor extends Armor{
    public UltimateArmor(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }

    @Override
    public int addDefense() {
        return super.addDefense() + 50;
    }

}
