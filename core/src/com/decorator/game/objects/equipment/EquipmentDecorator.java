package com.decorator.game.objects.equipment;

import java.util.ArrayList;
import java.util.List;

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
    public void removeEquipment(Class<Equipment> decoratorToRemove) {
        List<Class<? extends Equipment>> decoratorsToRemove = new ArrayList<>();
        decoratorsToRemove.add(decoratorToRemove);
        setEquipment(removeDecoratorsRecursively(decoratorsToRemove, getEquipment()));
    }

    private Equipment removeDecoratorsRecursively(List<Class<? extends Equipment>> decoratorsToRemove, Equipment currentEquipment) {
        Equipment decoratedEquipment = currentEquipment;

        if (currentEquipment instanceof EquipmentDecorator) {
            EquipmentDecorator decorator = (EquipmentDecorator) currentEquipment;

            if (decoratorsToRemove.contains(decorator.getClass())) {
                decoratedEquipment = decorator.getEquipment();
            } else {
                decorator.setEquipment(removeDecoratorsRecursively(decoratorsToRemove, decorator.getEquipment()));
            }
        }

        return decoratedEquipment;
    }
}
