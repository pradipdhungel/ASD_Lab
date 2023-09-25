package com.example.camera.handler;

import com.example.camera.model.Camera;

public class StolenCarHandler extends Handler {
    public StolenCarHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Camera camera) {
        if(camera.isStolen()){
            System.out.println("Notifying Police about stolen car: "+camera.getLicencePlate());
        }
        else {
            nextHandler.handle(camera);
        }
    }
}
