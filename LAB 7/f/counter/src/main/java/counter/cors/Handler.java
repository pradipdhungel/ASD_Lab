package counter.cors;

public abstract class Handler {
    public Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }

    public abstract void handle(int count);
}
