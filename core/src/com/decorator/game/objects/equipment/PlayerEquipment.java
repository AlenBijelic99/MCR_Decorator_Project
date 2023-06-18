package com.decorator.game.objects.equipment;

import com.decorator.game.utils.Constants;

public class PlayerEquipment implements Equipment {

  @Override
  public String getDescription() {
    return "Player equipment";
  }

  @Override
  public int addStrength() {
    return 10;
  }

  @Override
  public float addSpeed() {
    return Constants.PLAYER_SPEED;
  }

  @Override
  public float addJump() {
    return Constants.MAX_JUMPING_HEIGHT;
  }

  @Override
  public int addDefense() {
    return 0;
  }

  @Override
  public void setEquipment(Equipment equipment) {
    System.out.println("No equipment to set");
  }

  @Override
  public Equipment getEquipment() {
    return this;
  }

  @Override
  public Equipment removeEquipment(Class<Equipment> c) {
    System.out.println("No equipment to remove");
    return this;
  }

  @Override
  public String toString() {
    return "Player equipment";
  }
}
