package example;
import example.jewelry.menu.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        CommandProcessor commandProcessor = new CommandProcessor();

        ConsoleMenu consoleMenu = new ConsoleMenu(commandProcessor);
        logger.info("Програма почалася");

        while (true) {
            consoleMenu.displayMenu();
            consoleMenu.processUserChoice();
        }
    }
}