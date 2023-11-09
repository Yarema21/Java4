package example.jewelry.menu;

import example.jewelry.menu.commands.Command;

public class CommandProcessor {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void processCommand() {
        command.execute();
    }
}