package com.decorator.game.objects.equipment;

import com.badlogic.gdx.physics.box2d.Body;

public interface Equipment {
    String toString();
    String getDescription();
    int addStrength();
    float addSpeed();
    float addJump();
    int addDefense();
    int addAttack();
    Equipment removeDecorator(Class<? extends Equipment> decoratorClass);

}

