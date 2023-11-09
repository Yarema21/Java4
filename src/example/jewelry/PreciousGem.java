package example.jewelry;

import java.util.Random;

public class PreciousGem extends Stone {
    private static final double CARAT_LOW = 0.5;
    private static final double CARAT_HIGH = 2.0;


    public PreciousGem(String name, double carat,String transparency) {
        super(name, carat,transparency);
    }


    // Геттер та сеттер для полів PreciousGem

    // Реалізація абстрактного методу для створення рандомного коштовного каменю

    public static PreciousGem createRandomStone() {
        Random random = new Random();
        String[] gemNames = {"смарагд", "діамант", "сапфір", "рубін"};
        String randomGemName = gemNames[random.nextInt(gemNames.length)];
        String[] Transparency ={"прозорий","легко прозорий","напів прозорий"};
        String RandomTransparency = Transparency[random.nextInt(Transparency.length)];
        return new PreciousGem(randomGemName, 1.0 + random.nextDouble(), RandomTransparency);
    }
}