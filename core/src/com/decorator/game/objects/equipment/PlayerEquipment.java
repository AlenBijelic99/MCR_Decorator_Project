package com.decorator.game.objects.equipment;
import com.badlogic.gdx.physics.box2d.Body;
import com.decorator.game.utils.Constants;

import java.util.LinkedList;
import java.util.List;
public class PlayerEquipment implements Equipment {
    private List<Equipment> equipmentList;

    public PlayerEquipment() {
        equipmentList = new LinkedList<>();
    }
    public void addEquipment(Equipment equipment){
        equipmentList.add(equipment);
    }

    public void removeEquipment(Equipment equipment) {
        equipmentList.remove(equipment);
    }
    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder("Player's equipment: ");
        for (Equipment equipment : equipmentList) {
            description.append(equipment.getDescription()).append(", ");
        }
        // Remove the trailing comma and space
        if (equipmentList.size() > 0) {
            description.setLength(description.length() - 2);
        }
        return description.toString();
    }


    @Override
    public int addStrength() {
        int totalStrength = 10;
        for (Equipment equipment : equipmentList) {
            totalStrength += equipment.addStrength();
        }
        return totalStrength;
    }


    @Override
    public float addSpeed() {
        float totalSpeed = Constants.PLAYER_SPEED;
        for (Equipment equipment : equipmentList) {
            totalSpeed += equipment.addSpeed();
        }
        return totalSpeed;
    }



    @Override
    public float addJump() {
        float totalJump = Constants.MAX_JUMPING_HEIGHT;
        for (Equipment equipment : equipmentList) {
            totalJump += equipment.addJump();
        }
        return totalJump;
    }

    @Override
    public int addDefense() {
        int totalDefense = 0;
        for (Equipment equipment : equipmentList) {
            totalDefense += equipment.addDefense();
        }
        return totalDefense;
    }
    @Override
    public int addAttack() {
        int totalAttack = 0;
        for (Equipment equipment : equipmentList) {
            totalAttack += equipment.addAttack();
        }
        return totalAttack;
    }

    @Override
    public Equipment removeDecorator(Class<? extends Equipment> decoratorClass) {
        List<Equipment> updatedEquipmentList = new LinkedList<>();
        Equipment removedDecorator = null;

        for (Equipment equipment : equipmentList) {
            if (decoratorClass.isInstance(equipment)) {
                removedDecorator = equipment;
            } else {
                updatedEquipmentList.add(equipment);
            }
        }

        equipmentList = updatedEquipmentList;
        return removedDecorator;
    }


    @Override
    public String toString() {
        return "Player equipment";
    }
}