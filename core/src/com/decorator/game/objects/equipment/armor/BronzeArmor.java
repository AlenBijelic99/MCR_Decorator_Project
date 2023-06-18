package com.decorator.game.objects.equipment.armor;

import com.decorator.game.objects.equipment.Equipment;
import com.decorator.game.objects.equipment.PlayerEquipment;

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

 }
