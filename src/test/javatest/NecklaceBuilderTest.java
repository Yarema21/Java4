import example.jewelry.inventory.Inventory;
import example.jewelry.necklace.Necklace;
import example.jewelry.necklace.NecklaceBuilder;
import example.jewelry.Stone;
import example.jewelry.HalfPreciousStone;
import example.jewelry.PreciousGem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NecklaceBuilderTest {

    private Inventory gemstoneInventory;
    private NecklaceBuilder necklaceBuilder;
    private InputStream originalSystemIn;

    @BeforeEach
    void setUp() {
        // Підготовка інвентарю для тесту
        gemstoneInventory = new Inventory();
        // Додавання кількох каменів до інвентарю для тесту
        Stone gemstone1 = new PreciousGem("сапфір", 1.32, "напів прозорий");
        Stone gemstone2 = new HalfPreciousStone("агат", 4.19, "непрозорий");
        Stone gemstone3 = new PreciousGem("смарагд", 1.88, "легко прозорий");
        gemstoneInventory.addGemstones(List.of(gemstone1, gemstone2,gemstone3));


        // Створення об'єкта NecklaceBuilder для тестування
        necklaceBuilder = new NecklaceBuilder(gemstoneInventory);
        originalSystemIn = System.in;
    }
    @AfterEach
    void tearDown() {
        // Повернення оригінального System.in
        System.setIn(originalSystemIn);
        // Повернення оригінального System.out
        System.setOut(System.out);
    }

    @Test
    void testCreateNecklaceWithValidInput() {
        // Підготовка введених даних для тестування
        String input = "1,2,3\n"; // Введення валідних номерів каменів з інвентарю
        InputStream in = new ByteArrayInputStream(input.getBytes());

        // Збереження стандартного введення для повернення його назад після тесту
        System.setIn(in);
        necklaceBuilder.setScannerNecklace(new Scanner(in));
        // Виклик методу, який має бути протестований
        Necklace necklace = necklaceBuilder.createNecklace();

        // Перевірка, що кількість доданих каменів дорівнює очікуваній кількості
        List<Stone> gemstones = necklace.getGemstoneListNecklace();
        assertEquals(3, gemstones.size());

    }
    @Test
    void testCreateNecklaceMethodsGemstoneByValue(){
        // Підготовка введених даних для тестування
        String input = "1,2,3\n"; // Введення валідних номерів каменів з інвентарю
        InputStream in = new ByteArrayInputStream(input.getBytes());

        // Збереження стандартного введення для повернення його назад після тесту
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(in);
        necklaceBuilder.setScannerNecklace(new Scanner(in));
        // Виклик методу, який має бути протестований
        Necklace necklace = necklaceBuilder.createNecklace();


        // Тепер тестуємо методи класу Necklace, наприклад:
        necklace.sortGemstonesByValue();

        String expectedOutput = "Gemstones:\r\nStone [name = агат, carat = 4.19, непрозорий ]\r\nStone [name = сапфір, carat = 1.32, напів прозорий ]\r\nStone [name = смарагд, carat = 1.88, легко прозорий ]\r\n";
        assertTrue(outputStreamCaptor.toString().contains(expectedOutput));
    }
    @Test
    void testCreateNecklaceMethodsGetTotalWeight() {
        // Підготовка введених даних для тестування
        String input = "1,2,3\n"; // Введення валідних номерів каменів з інвентарю
        InputStream in = new ByteArrayInputStream(input.getBytes());

        // Збереження стандартного введення для повернення його назад після тесту
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(in);
        necklaceBuilder.setScannerNecklace(new Scanner(in));
        // Виклик методу, який має бути протестований
        Necklace necklace = necklaceBuilder.createNecklace();


        // Тепер тестуємо методи класу Necklace, наприклад:
        necklace.getTotalWeight();

        String expectedOutput = "\nTotal Weight: 7.390000000000001 carats";
        assertTrue(outputStreamCaptor.toString().contains(expectedOutput));

    }

    @Test
    void testCreateNecklaceMethodsGetTotalValue() {
        // Підготовка введених даних для тестування
        String input = "1,2,3\n"; // Введення валідних номерів каменів з інвентарю
        InputStream in = new ByteArrayInputStream(input.getBytes());

        // Збереження стандартного введення для повернення його назад після тесту
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(in);
        necklaceBuilder.setScannerNecklace(new Scanner(in));
        // Виклик методу, який має бути протестований
        Necklace necklace = necklaceBuilder.createNecklace();


        // Тепер тестуємо методи класу Necklace, наприклад:
        necklace.getTotalValue();

        String expectedOutput = "\nTotal Value: 9400.0$";
        assertTrue(outputStreamCaptor.toString().contains(expectedOutput));

    }

    @Test
    void testCreateNecklaceFalse() {
        // Підготовка введених даних для тестування
        String input = "0\n"; // Введення валідних номерів каменів з інвентарю
        InputStream in = new ByteArrayInputStream(input.getBytes());

        // Збереження стандартного введення для повернення його назад після тесту
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(in);
        necklaceBuilder.setScannerNecklace(new Scanner(in));
        // Виклик методу, який має бути протестований
        Necklace necklace = necklaceBuilder.createNecklace();


        String expectedOutput = "\nInvalid choice: 0";
        assertTrue(outputStreamCaptor.toString().contains(expectedOutput));

    }

}
