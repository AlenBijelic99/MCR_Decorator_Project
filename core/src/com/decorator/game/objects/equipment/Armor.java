package com.decorator.game.objects.equipment;

public class Armor extends EquipmentDecorator {
    public Armor(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }


}
