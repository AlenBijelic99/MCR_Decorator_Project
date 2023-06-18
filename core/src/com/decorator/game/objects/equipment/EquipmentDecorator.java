package com.decorator.game.objects.equipment;

/**
 * Reprsents the equipment decorator.
 *
 * @author : Bijelic Alen, Bogale Tegest , Gillioz Dorian
 * @version : 11.0.12
 * @since : 17.05.2023
 */
public class EquipmentDecorator implements Equipment {
    protected Equipment equipment;

    /**
     * Constructor that creates an equipment decorator.
     *
     * @param equipment equipment
     */
    public EquipmentDecorator(Equipment equipment) {
        this.equipment = equipment;
    }

    /**
     * Returns the description of the decorated equipment.
     *
     * @return String represent the name of the equipment
     */
    @Override
    public String getDescription() {
        return equipment.getDescription();
    }

    /**
     * Returns the strength of the decorated equipment.
     *
     * @return int represent the strength of the equipment
     */
    @Override
    public int addStrength() {
        return equipment.addStrength();
    }

    /**
     * Returns the speed of the decorated equipment.
     *
     * @return float represent the speed of the equipment
     */
    @Override
    public float addSpeed() {
        return equipment.addSpeed();
    }

    /**
     * Returns the jumping capacity of the decorated equipment.
     *
     * @return float represent the jumping capacity of the equipment
     */
    @Override
    public float addJump() {
        return equipment.addJump();
    }

    /**
     * Returns the defense of the decorated equipment.
     *
     * @return int represent the defense of the equipment
     */
    @Override
    public int addDefense() {
        return equipment.addDefense();
    }

    /**
     * Sets the equipment.
     *
     * @param equipment equipment
     */
    @Override
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    /**
     * Returns the equipment.
     *
     * @return equipment
     */
    @Override
    public Equipment getEquipment() {
        return equipment;
    }

    /**
     * Adds an equipment.
     *
     * @param c class of the equipment to remove
     * @return equipment after eventually removing the decorated equipment
     */
    @Override
    public void removeEquipment(Class<Equipment> c) {
        if (equipment.getClass() == c) {
            System.out.println("Removing " + equipment.getClass().getSimpleName());
            equipment = equipment.getEquipment();
        } else if (equipment instanceof EquipmentDecorator) {
            equipment.removeEquipment(c);
        }
    }

    /**
     * Returns the name of the decorated equipment.
     *
     * @return String represent the name of the equipment
     */
    @Override
    public String toString() {
        return equipment.toString();
    }
}
