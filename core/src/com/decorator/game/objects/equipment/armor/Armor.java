package com.decorator.game.objects.equipment.armor;

import com.decorator.game.objects.equipment.Equipment;
import com.decorator.game.objects.equipment.EquipmentDecorator;
import com.decorator.game.objects.equipment.PlayerEquipment;

import static com.decorator.game.utils.Constants.DAGGER_DAMAGE;

public abstract class Armor extends EquipmentDecorator {
    public Armor(Equipment equipment) {
        super(equipment);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + this.getClass().getSimpleName();
    }


    @Override
    public String toString() {
        return "None";
    }


}
