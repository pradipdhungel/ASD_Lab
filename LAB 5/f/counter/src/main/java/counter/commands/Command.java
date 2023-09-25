package counter.commands;

import counter.Iobserver;
public interface Command {
    void execute();

    void unExecute();
}
