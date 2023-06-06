package com.decorator.game.objects.equipment;

public class EquipmentDecorator implements Equipment {
    private Equipment equipment;

    public EquipmentDecorator(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String getDescription() {
        return equipment.getDescription();
    }

    @Override
    public int addStrength() {
        return equipment.addStrength();
    }

    @Override
    public float addSpeed() {
        return equipment.addSpeed();
    }

    @Override
    public float addJump() {
        return equipment.addJump();
    }

    @Override
    public int addDefense() {
        return equipment.addDefense();
    }

}
