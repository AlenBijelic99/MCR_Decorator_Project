package com.decorator.game.objects.equipment;

public interface Equipment {
    String toString();
    String getDescription();
    int addStrength();
    float addSpeed();
    float addJump();
    int addDefense();
}
