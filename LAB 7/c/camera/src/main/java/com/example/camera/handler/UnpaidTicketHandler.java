package com.example.camera.handler;

import com.example.camera.model.Camera;

public class UnpaidTicketHandler extends Handler  {
    public UnpaidTicketHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Camera camera) {
       if(camera.isUnpaid()){
           System.out.println("Notifying police of unpaid tickets of car:"+camera.getLicencePlate());
       }
    }
}
