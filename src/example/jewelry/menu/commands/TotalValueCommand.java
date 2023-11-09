package example.jewelry.menu.commands;

import example.jewelry.necklace.Necklace;
import example.jewelry.menu.commands.CreateNecklaceCommand;
public class TotalValueCommand implements Command {
    private Necklace necklace = CreateNecklaceCommand.getResult();
    public void getTotalValueCommand(Necklace necklace) {
        this.necklace = necklace;
    }

    @Override
    public void execute() {
        necklace.getTotalValue();
    }
}
