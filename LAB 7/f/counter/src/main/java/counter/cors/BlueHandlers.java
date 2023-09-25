package counter.cors;

public class BlueHandlers  extends Handler{


    public BlueHandlers(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(int count) {
        if(count%2!=0&&count<15||count==17||count==19){
            System.out.println("Its Blue");
        }else {
            nextHandler.handle(count);
        }
    }
}
