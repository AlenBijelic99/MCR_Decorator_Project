package com.decorator.game.objects.equipment.armor;

import com.decorator.game.objects.equipment.Equipment;

import static com.decorator.game.utils.Constants.SILVER_ARMOR_DEFENSE;

public class SilverArmor extends Armor {
    public SilverArmor(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }

    @Override
    public int addDefense() {
        return super.addDefense() + SILVER_ARMOR_DEFENSE;
    }

    @Override
    public String toString() {
        return "Silver";
    }

    @Override
    public void removeEquipment(Class<Equipment> equipmentClass) {
        System.out.println("D SilverArmor removeEquipment");
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
