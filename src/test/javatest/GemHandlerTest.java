import example.jewelry.handler.GemHandler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import example.jewelry.Stone;
import example.jewelry.inventory.Inventory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.util.Scanner;

class GemHandlerTest {

    private Inventory inventory;
    private GemHandler gemHandler;
    private InputStream originalSystemIn;
    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        gemHandler  = new GemHandler(inventory);
        // Збереження оригінального System.in
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
    void testDontCreateRandomGem() {
            // Підготовка введених даних для тестування
            String input = "ні\n2\n"; // Вибір "Завершити", "ні", "Продовжити пошук", "так", "Завершити" з новими рядками
            InputStream in = new ByteArrayInputStream(input.getBytes());

            // Встановлення власного Scanner перед викликом методу createRandomGem
            System.setIn(in);
            gemHandler.setScanner(new Scanner(in));

            // Виклик методу, який має бути протестований
            gemHandler.createRandomGem();

            // Перевірка, що камінь не був доданий до інвентаря
            List<Stone> gemstones = inventory.getGemstoneList();
            assertEquals(0, gemstones.size());
        }
    @Test
    void testCreateRandomGem() {
        // Підготовка введених даних для тестування
        String input = "так\nні\n2\n"; // Вибір "Завершити", "ні", "Продовжити пошук", "так", "Завершити" з новими рядками
        InputStream in = new ByteArrayInputStream(input.getBytes());

        // Встановлення власного Scanner перед викликом методу createRandomGem
        System.setIn(in);
        gemHandler.setScanner(new Scanner(in));

        // Виклик методу, який має бути протестований
        gemHandler.createRandomGem();

        // Перевірка, що камінь не був доданий до інвентаря
        List<Stone> gemstones = inventory.getGemstoneList();
        assertEquals(1, gemstones.size());
    }
    @Test
    void testCreateRandomGemMore() {
        // Підготовка введених даних для тестування
        String input = "так\nтак\nні\n2\n"; // Вибір "Завершити", "ні", "Продовжити пошук", "так", "Завершити" з новими рядками
        InputStream in = new ByteArrayInputStream(input.getBytes());

        // Встановлення власного Scanner перед викликом методу createRandomGem
        System.setIn(in);
        gemHandler.setScanner(new Scanner(in));

        // Виклик методу, який має бути протестований
        gemHandler.createRandomGem();

        // Перевірка, що камінь не був доданий до інвентаря
        List<Stone> gemstones = inventory.getGemstoneList();
        assertEquals(2, gemstones.size());
    }
    @Test
    void testMakeANumberMistake() {
        // Підготовка введених даних для тестування
        String input = "ні\n3\n2"; // Вибір "Завершити", "ні", "Продовжити пошук", "так", "Завершити" з новими рядками
        InputStream in = new ByteArrayInputStream(input.getBytes());


        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(in);
        gemHandler.setScanner(new Scanner(in));

        // Виклик методу, який має бути протестований
        gemHandler.createRandomGem();

        String expectedOutput = "Ви ввели не правильний варіант, спробуйте ще раз:";
        assertTrue(outputStreamCaptor.toString().contains(expectedOutput));
    }
    @Test
    void testMakeAStringMistake() {
        // Підготовка введених даних для тестування
        String input = "ні\nBleh\n2"; // Вибір "Завершити", "ні", "Продовжити пошук", "так", "Завершити" з новими рядками
        InputStream in = new ByteArrayInputStream(input.getBytes());


        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(in);
        gemHandler.setScanner(new Scanner(in));

        // Виклик методу, який має бути протестований
        gemHandler.createRandomGem();

        String expectedOutput = "Введено некоректно число, спробуйте ще раз:";
        assertTrue(outputStreamCaptor.toString().contains(expectedOutput));
    }
    @Test
    void testChooseOtherThanNO_YES_Number() {
        // Підготовка введених даних для тестування
        String input = "3\nні\n2"; // Вибір "Завершити", "ні", "Продовжити пошук", "так", "Завершити" з новими рядками
        InputStream in = new ByteArrayInputStream(input.getBytes());


        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(in);
        gemHandler.setScanner(new Scanner(in));

        // Виклик методу, який має бути протестований
        gemHandler.createRandomGem();

        String expectedOutput = "Введено некоректну відповідь. Будь ласка, введіть 'так' або 'ні'.";
        assertTrue(outputStreamCaptor.toString().contains(expectedOutput));
    }
}

