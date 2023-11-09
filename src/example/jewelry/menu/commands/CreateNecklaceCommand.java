package example.jewelry.menu.commands;

import example.jewelry.necklace.NecklaceBuilder;
import example.jewelry.necklace.Necklace;
import example.jewelry.inventory.Inventory;

public class CreateNecklaceCommand implements Command {
    private NecklaceBuilder necklaceBuilder;
    private Inventory gemstoneInventory;
    private static Necklace result;
    public CreateNecklaceCommand(NecklaceBuilder necklaceBuilder, Inventory gemstoneInventory) {
        this.necklaceBuilder = necklaceBuilder;
        this.gemstoneInventory = gemstoneInventory;
    }
    public static Necklace getResult() {
        return result;
    }
    @Override
    public void execute() {
        result = necklaceBuilder.createNecklace();
    }
}