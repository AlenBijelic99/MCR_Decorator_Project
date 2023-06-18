package com.decorator.game.objects.equipment;

public class EquipmentDecorator implements Equipment {
    protected Equipment equipment;

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

    @Override
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public Equipment getEquipment() {
        return equipment;
    }

    @Override
    public String toString() {
        return equipment.toString();
    }

    @Override
    public Equipment removeEquipment(Class<Equipment> c) {
        if (equipment.getClass() == c) {
            System.out.println("Removing " + equipment.getClass().getSimpleName());
            equipment = equipment.getEquipment();
        } else if (equipment instanceof EquipmentDecorator) {
            equipment.removeEquipment(c);
        }
        return equipment;
    }
}
