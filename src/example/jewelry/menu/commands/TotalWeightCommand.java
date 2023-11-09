package example.jewelry.menu.commands;

import example.jewelry.necklace.Necklace;

public class TotalWeightCommand implements Command {
    private Necklace necklace = CreateNecklaceCommand.getResult();

    public void getTotalWeightCommand(Necklace necklace) {
        this.necklace = necklace;
    }

    @Override
    public void execute() {
        necklace.getTotalWeight();
    }
}
