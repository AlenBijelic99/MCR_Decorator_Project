package com.decorator.game.objects.equipment;

public interface Equipment {
    String toString();
    String getDescription();
    int addStrength();
    float addSpeed();
    float addJump();
    int addDefense();
    void setEquipment(Equipment equipment);
    Equipment getEquipment();
    void removeEquipment(Class<Equipment> c);
}
