package com.example.camera.model;

public class Camera {
    private int cameraId;
    private boolean register;
    private String licencePlate;
    private boolean stolen;
    private int speed;
    private boolean unpaid;

    public Camera(int cameraId, boolean register, String licencePlate, boolean stolen, int speed, boolean unpaid) {
        this.cameraId = cameraId;
        this.register = register;
        this.licencePlate = licencePlate;
        this.stolen = stolen;
        this.speed = speed;
        this.unpaid = unpaid;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isRegistered() {
        return  register;
    }

    public boolean isUnpaid() {
        return  unpaid;
    }

    public boolean isStolen() {
        return stolen;
    }
}
