package ru.taravkov.ifmo.webservices.entity;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author vtaravkov
 * @since lab1
 */
@XmlRootElement
public class Car {
    private String make;

    private String model;

    private Color color;

    private VehicleClass vehicleClass;

    private Boolean rightHand;

    public Car() {
    }

    public Car(String make, String model, Color color, VehicleClass vehicleClass, Boolean rightHand) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.vehicleClass = vehicleClass;
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

    public VehicleClass getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(VehicleClass vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public Boolean getRightHand() {
        return rightHand;
    }

    public void setRightHand(Boolean rightHand) {
        this.rightHand = rightHand;
    }
}
