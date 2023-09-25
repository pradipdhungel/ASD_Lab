package counter.commands;

import java.util.ArrayList;
import java.util.List;

public class HistoryList {
    private final List<Command> commands = new ArrayList<>();
    private final List<Command> undoList = new ArrayList<>();

    public void undo() {
        if (commands.size() > 0) {
            Command command = commands.get(commands.size() - 1);
            commands.remove(command);
            command.unExecute();
            undoList.add(command);
        }
    }

    public void redo() {
        if (undoList.size() > 0) {
            Command command = commands.get(undoList.size() - 1);
            command.execute();
            undoList.remove(command);
            commands.add(command);
        }
    }
    public void addCommand(Command command){
        commands.add(command);
    }

}
