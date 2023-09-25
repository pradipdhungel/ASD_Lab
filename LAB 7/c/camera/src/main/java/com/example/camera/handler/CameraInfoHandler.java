package com.example.camera.handler;


import com.example.camera.model.Camera;

public class CameraInfoHandler {
    private Handler chainOfHandler;
public void setChainOfHandler(Handler chainOfHandler){
    this.chainOfHandler=chainOfHandler;
}
  public void handleCameraInfo(Camera camera){
    chainOfHandler.handle(camera);
  }

}
