package example.jewelry;

public abstract class Stone {
    static protected String[] gemNames = {"смарагд", "діамант", "сапфір", "рубін", "аметист", "топаз", "агат", "гранат"};
    static protected double[] pricesPerCarat = {5000.0, 1500.0, 500.0, 1000.0, 20.0, 10.0, 1.0, 20.0};

    public static String[] getGemNames() {
        return gemNames;
    }
    public static double[] getPricesPerCarat() {
        return pricesPerCarat;
    }
    protected String name;
    protected double carat;
    protected String transparency;

    public Stone(String name, double carat,String transparency) {
        this.name = name;
        this.carat = carat;
        this.transparency = transparency;
    }

    public String getName() {
        return name;
    }
    public double getCaratWeight() {
        return carat;
    }

    public static double getPrice(Stone gemstone){
        double Price = 0.0;
        for (int j = 0; j < Stone.getGemNames().length; j++) {
            if (gemstone.getName().equals(Stone.getGemNames()[j])) {
                Price = gemstone.getCaratWeight() * Stone.getPricesPerCarat()[j];

            }
        }
        return Price;
    }
    @Override
    public String toString() {
        // Повертає рядок, який представляє об'єкт Stone
        return "Stone [name = " + name + ", carat = " + carat + ", " + transparency + " ]";
    }
}