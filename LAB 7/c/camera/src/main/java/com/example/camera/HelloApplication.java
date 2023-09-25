package com.example.camera;

import com.example.camera.handler.*;
import com.example.camera.model.Camera;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication {


    public static void main(String[] args) {
        CameraInfoHandler cameraInfoHandler=new CameraInfoHandler();
        UnpaidTicketHandler unpaidTicketHandler=new UnpaidTicketHandler(null);
        RegistrationHandler registrationHandler=new RegistrationHandler(unpaidTicketHandler);
        SpeedHandler speedHandler=new SpeedHandler(registrationHandler,100);
        StolenCarHandler stolenHandler=new StolenCarHandler(speedHandler);

        cameraInfoHandler.setChainOfHandler(stolenHandler);

        cameraInfoHandler.setChainOfHandler(stolenHandler);

        cameraInfoHandler.handleCameraInfo(new Camera(1,true,"Tx-553",false,200,false));
        cameraInfoHandler.handleCameraInfo(new Camera(2,false,"IA-553",true,120,true));
        cameraInfoHandler.handleCameraInfo(new Camera(3,true,"CA-553",false,100,false));
        cameraInfoHandler.handleCameraInfo(new Camera(4,true,"IL-553",true,80,true));
    }
}