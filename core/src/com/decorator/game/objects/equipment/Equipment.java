package com.decorator.game.objects.equipment;

public interface Equipment {
    String getDescription();
    int addPower();
    float addSpeed();
    float addJump();

    int addDefense();
}
