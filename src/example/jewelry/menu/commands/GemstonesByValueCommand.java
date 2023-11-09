package example.jewelry.menu.commands;

import example.jewelry.necklace.Necklace;

public class GemstonesByValueCommand implements Command {
    private Necklace necklace = CreateNecklaceCommand.getResult();

    public void sortGemstonesByValue(Necklace necklace) {
    this.necklace = necklace;
    }

    @Override
    public void execute() {
        necklace.sortGemstonesByValue();
    }
}
