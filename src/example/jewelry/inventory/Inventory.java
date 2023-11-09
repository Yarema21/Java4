package example.jewelry.inventory;
import example.jewelry.Stone;
import java.util.ArrayList;
import java.util.List;
public class Inventory {
    private List<Stone> gemstoneList;

    public Inventory() {
        gemstoneList = new ArrayList<>();
    }

    public void addGemstone(Stone gemstone) {
        gemstoneList.add(gemstone);
    }
    public void addGemstones(List<Stone> gemstones) {
        gemstoneList.addAll(gemstones);
    }

    public List<Stone> getGemstoneList() {
        return gemstoneList;
    }

    public int size() {
        return gemstoneList.size();
    }

    public Stone get(int i) {
        if (i >= 0 && i < gemstoneList.size()) {
            return gemstoneList.get(i);
        } else {
            return null;
        }
    }
}