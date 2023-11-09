package example.jewelry.menu;
import example.jewelry.handler.GemHandler;
import example.jewelry.inventory.Inventory;
import example.jewelry.menu.commands.*;
import example.jewelry.necklace.Necklace;
import example.jewelry.necklace.NecklaceBuilder;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ConsoleMenu {
   private static final Logger logger = LogManager.getLogger(ConsoleMenu.class);
    private Inventory inventory = new Inventory();
    private NecklaceBuilder necklaceBuilder = new NecklaceBuilder(inventory);
    private GemHandler gemHandler = new GemHandler(inventory);
    private Necklace necklace;
    private CommandProcessor commandProcessor;

    public ConsoleMenu(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    public void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Create Necklace");
        System.out.println("2. Add Stone");
        System.out.println("3. Total Value");
        System.out.println("4. Total Weight");
        System.out.println("5. Sort Gemstones By Value");
        System.out.println("0. Exit");
    }
    boolean stoneAdded = false;
    boolean NecklaceExists = false;
    public Command getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            try {
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

            switch (choice) {
                case 1:
                    if(stoneAdded){
                        NecklaceExists = true;
                    return new CreateNecklaceCommand(necklaceBuilder, inventory);
                    }
                    else {
                        System.out.println("Find Stones first.");
                        return getUserChoice();}
                case 2:
                    stoneAdded = true;
                    return new AddStoneCommand(gemHandler);
                case 3:
                    if (NecklaceExists) {
                         return new TotalValueCommand();
                    } else {
                        System.out.println("Create a necklace with gemstones first.");
                        return getUserChoice();
                    }
                case 4:
                    if (NecklaceExists) {
                        return new TotalWeightCommand();
                    } else {
                        System.out.println("Create a necklace with gemstones first.");
                        return getUserChoice();
                    }
                case 5:
                    if (NecklaceExists) {
                        return new GemstonesByValueCommand();
                    } else {
                        System.out.println("Create a necklace with gemstones first.");
                        return getUserChoice();
                    }
                case 0:
                    System.out.println("Exiting the program.");
                    logger.info("Програма завершилася");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    return getUserChoice();
                }

    }

    public void processUserChoice() {
        Command userChoice = getUserChoice();
        commandProcessor.setCommand(userChoice);
        commandProcessor.processCommand();
    }
}