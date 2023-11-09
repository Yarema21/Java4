package example.jewelry;
import java.util.Random;

public class HalfPreciousStone extends Stone {
    private static final double CARAT_LOW = 1.0;
    private static final double CARAT_HIGH = 5.0;


    public HalfPreciousStone(String name, double carat,String transparency) {
        super(name, carat,transparency);
    }

    // Геттер та сеттер для полів HalfPreciousStone

    // Реалізація абстрактного методу для створення рандомного напівкоштовного каменю
    public static HalfPreciousStone createRandomStone() {
        Random random = new Random();
        String[] stoneNames = {"аметист", "топаз", "агат", "гранат"};
        String randomStoneName = stoneNames[random.nextInt(stoneNames.length)];
        String[] Transparency ={"прозорий","легко прозорий","напів прозорий","непрозорий"};
        String RandomTransparency = Transparency[random.nextInt(Transparency.length)];
        return new HalfPreciousStone(randomStoneName, 1.0 + random.nextDouble() * 4.0,RandomTransparency);
    }
}