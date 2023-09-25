package com.example.camera.handler;


import com.example.camera.model.Camera;

public class RegistrationHandler extends Handler{

    public RegistrationHandler(Handler nextHandler){
        super(nextHandler);
    }
    @Override
    public void handle(Camera camera) {
        if(!camera.isRegistered()){
            System.out.println("Car is not registered. Sending ticket to car="+camera.getLicencePlate());
        } else {
            nextHandler.handle(camera);
        }
    }


}
