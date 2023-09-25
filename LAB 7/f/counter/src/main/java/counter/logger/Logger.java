package counter.logger;

import counter.observer.Iobserver;


public class Logger implements Iobserver {
    @Override
    public void update(int count) {
        log(count);
    }

    private void log(int count) {
        System.out.println("Logging value of this count is:"+count);
    }
}
