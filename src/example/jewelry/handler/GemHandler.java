package example.jewelry.handler;

import example.jewelry.Stone;
import example.jewelry.HalfPreciousStone;
import example.jewelry.PreciousGem;
import example.jewelry.inventory.Inventory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;
import java.util.Scanner;

public class GemHandler {
    private static final Logger logger = LogManager.getLogger(GemHandler.class);
    private Inventory inventory;
    private Scanner scanner;

    public GemHandler(Inventory inventory) {
        this.inventory = inventory;
        this.scanner = new Scanner(System.in);
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createRandomGem() {

        while (true) {
            Random random = new Random();
            String[] gemTypes = {"PreciousGem", "HalfPreciousStone"};
            String randomType = gemTypes[random.nextInt(gemTypes.length)];

            Stone stone = null;

            switch (randomType) {
                case "PreciousGem":
                    stone = HalfPreciousStone.createRandomStone();
                    break;
                case "HalfPreciousStone":
                    stone = PreciousGem.createRandomStone();
                    break;
                default:
                    break;
            }

            if (stone != null && shouldKeepGem(stone)) {
                    inventory.addGemstone(stone);
                    System.out.println("Камінь додано до інвентаря.");
            } else {
                String input;
                int choice;
                while (true) {
                    System.out.println("Виберіть дію: 1 - Продовжити пошук, 2 - Завершити");

                    input = scanner.nextLine();

                    try {
                        choice = Integer.parseInt(input);

                        if (choice == 1 || choice == 2) {
                            break;
                        } else {
                            System.out.println("Ви ввели не правильний варіант, спробуйте ще раз:");
                            logger.warn("Користувач ввів не ту цифру: {}", choice);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Введено некоректно число, спробуйте ще раз:");
                        logger.error("Користувач ввів не цифру: {}", input);
                    }
                }
                if (choice == 2) {
                    System.out.println("Ви завершили пошук!");
                    break;
                }
            }
        }
    }

    private boolean shouldKeepGem(Stone stone) {
        String response;

        do {
            System.out.print("Чи хочете залишити цей камінь - " + stone.getName() + "? (так/ні): ");
            response = scanner.nextLine();

            if (!response.equals("так") && !response.equals("ні")) {
                System.out.println("Введено некоректну відповідь. Будь ласка, введіть 'так' або 'ні'.");
            }
        } while (!response.equals("так") && !response.equals("ні"));

        return response.equals("так");
    }

}