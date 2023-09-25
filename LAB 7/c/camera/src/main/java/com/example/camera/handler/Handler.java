package com.example.camera.handler;


import com.example.camera.model.Camera;

public abstract class Handler {

    protected  Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public  Handler getNextHandler(){
        return nextHandler;
    }
    public abstract void  handle(Camera camera);

}
