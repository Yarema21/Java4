package example.jewelry.necklace;
import example.jewelry.inventory.Inventory;

import java.util.Scanner;

public class NecklaceBuilder {
    private Inventory gemstoneInventory;
    private Scanner scanner;

    public NecklaceBuilder(Inventory gemstoneInventory) {
        this.gemstoneInventory = gemstoneInventory;
        this.scanner = new Scanner(System.in);
    }
    public void setScannerNecklace(Scanner scanner) {
        this.scanner = scanner;
    }
    public Necklace createNecklace() {
        Necklace necklace = new Necklace();

        System.out.println("Available gemstones in inventory:");
        for (int i = 0; i < gemstoneInventory.size(); i++) {
            System.out.println((i + 1) + ". " + gemstoneInventory.get(i));
        }

        System.out.println("Choose the numbers of gemstones you want to use for the necklace (separated by commas): ");
        String choice = scanner.nextLine();
        String[] gemstoneNumbers = choice.split(",");

        for (String number : gemstoneNumbers) {
            int gemstoneIndex = Integer.parseInt(number.trim()) - 1;
            if (gemstoneIndex >= 0 && gemstoneIndex < gemstoneInventory.size()) {
                necklace.addGemstone_toNecklace(gemstoneInventory.get(gemstoneIndex));
            } else {
                System.out.println("Invalid choice: " + number);
            }
        }

        return necklace;
    }
}
