package com.decorator.game.objects.equipment.armor;

import com.decorator.game.objects.equipment.Equipment;

import java.awt.*;

import static com.decorator.game.utils.Constants.BRONZE_ARMOR_DEFENSE;

public class BronzeArmor extends Armor{
    public BronzeArmor(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }

    @Override
    public int addDefense() {
        return super.addDefense() + BRONZE_ARMOR_DEFENSE;
    }

    @Override
    public String toString() {
        return "Bronze";
    }

    @Override
    public void removeEquipment(Class<Equipment> equipmentClass) {
        System.out.println("D BronzeArmor removeEquipment");
        if (this.getEquipment().getClass() == equipmentClass) {
            setEquipment(this.getEquipment().getEquipment());
        } else {
            super.removeEquipment(equipmentClass);
        }
    }

    @Override
    public Equipment getEquipment() {
        return super.getEquipment();
    }
}
