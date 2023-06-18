package com.decorator.game.objects.equipment;

import com.badlogic.gdx.physics.box2d.Body;

public abstract class EquipmentDecorator implements Equipment {
    private Equipment decoratedEquipment;

    public EquipmentDecorator(Equipment decoratedEquipment) {
        this.decoratedEquipment = decoratedEquipment;
    }

    @Override
    public String getDescription() {
        return decoratedEquipment.getDescription();
    }

    @Override
    public int addStrength() {
        return decoratedEquipment.addStrength();
    }

    @Override
    public float addSpeed() {
        return decoratedEquipment.addSpeed();
    }

    @Override
    public float addJump() {
        return decoratedEquipment.addJump();
    }

    @Override
    public int addDefense() {
        return decoratedEquipment.addDefense();
    }

    @Override
    public int addAttack() {
        return decoratedEquipment.addAttack();
    }
    @Override
    public Equipment removeDecorator(Class<? extends Equipment> decoratorClass) {
        if(decoratorClass.isInstance(decoratedEquipment)) {
            return decoratedEquipment;
        } else {
             decoratedEquipment.removeDecorator(decoratorClass);
             return this;
        }
    }
    public Equipment getDecoratedEquipment() {
        return decoratedEquipment;
    }


    @Override
    public String toString() {
        return decoratedEquipment.toString();
    }
}
