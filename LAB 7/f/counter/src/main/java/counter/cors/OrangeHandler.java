package counter.cors;

public class OrangeHandler extends Handler {
    public OrangeHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(int count) {
        if (count % 2 != 0 && count > 15 && count != 17 && count != 19) {
            System.out.println("Its orange");
        } else {
            nextHandler.handle(count);
        }
    }
}
