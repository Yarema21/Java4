package example.jewelry.necklace;
import example.jewelry.Stone;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
public class Necklace {
    private List<Stone> gemstones;
    public Necklace() {
        gemstones = new ArrayList<>();
    }
    public List<Stone> getGemstoneListNecklace() {
        return gemstones;
    }

    public void addGemstone_toNecklace(Stone gemstone) {
        gemstones.add(gemstone);
    }
    public void sortGemstonesByValue() {
        Collections.sort(gemstones, Comparator.comparingDouble(Stone::getPrice));
        displayGemstones(gemstones);
        System.out.println("(sorted by price) ");
    }
    public void getTotalWeight() {
        double totalWeight = 0;
        for (Stone gemstone : gemstones) {
            totalWeight += gemstone.getCaratWeight();
        }
        System.out.println("\nTotal Weight: " + totalWeight + " carats");
    }

    public void getTotalValue() {
        double totalValue = 0;
        for (Stone gemstone : gemstones) {
            totalValue = Stone.getPrice(gemstone);

        }
        System.out.println("\nTotal Value: " + totalValue + "$");
    }

    public void displayGemstones(List<Stone> stones) {
        System.out.println("Gemstones:");
        for (Stone gemstone : stones) {
            System.out.println(gemstone);
        }
    }
}