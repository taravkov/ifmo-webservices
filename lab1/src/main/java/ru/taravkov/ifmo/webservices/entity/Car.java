package ru.taravkov.ifmo.webservices.entity;

/**
 * @author vtaravkov
 * @since lab1
 */
public class Car {
    public enum Color {
        SILVER,

        BLACK,

        WHITE;
    }

    public enum Clazz {
        SUBCOMPACT,

        COMPACT,

        CROSSOVER;
    }

    private String make;

    private String model;

    private Color color;

    private Clazz clazz;

    private Boolean rightHand;

    public Car() {
    }

    public Car(String make, String model, Color color, Clazz clazz, Boolean rightHand) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.clazz = clazz;
        this.rightHand = rightHand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Boolean getRightHand() {
        return rightHand;
    }

    public void setRightHand(Boolean rightHand) {
        this.rightHand = rightHand;
    }
}
