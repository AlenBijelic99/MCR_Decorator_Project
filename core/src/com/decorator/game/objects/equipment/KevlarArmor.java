package com.decorator.game.objects.equipment;

public class KevlarArmor extends Armor{
    public KevlarArmor(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }

    @Override
    public int addDefense() {
        return super.addDefense() + 30;
    }
}
