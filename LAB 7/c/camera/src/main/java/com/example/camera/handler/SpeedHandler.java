package com.example.camera.handler;

import com.example.camera.model.Camera;

public class SpeedHandler extends Handler {
    private int speedLimit;

    public SpeedHandler(Handler nextHandler, int i) {
        super(nextHandler);
        this.speedLimit=speedLimit;
    }

    @Override
    public void handle(Camera camera) {
        if(camera.getSpeed()>speedLimit){
            System.out.println("Sending speeding ticket to:"+camera.getLicencePlate());
        }
        else {
            nextHandler.handle(camera);
        }
    }
}
