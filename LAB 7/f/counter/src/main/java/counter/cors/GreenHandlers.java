package counter.cors;

public class GreenHandlers extends Handler {
    public GreenHandlers(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(int count) {
        if (count % 2 == 0 && count >= 10 && count != 12 && count != 13) {
            System.out.println("Its green");
        } else {
            nextHandler.handle(count);
        }
    }
}
