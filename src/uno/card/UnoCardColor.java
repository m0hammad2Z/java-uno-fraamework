package uno.card;

import java.util.ArrayList;
import java.util.List;

public class UnoCardColor {

    public static final UnoCardColor RED;
    public static final UnoCardColor BLUE;
    public static final UnoCardColor GREEN;
    public static final UnoCardColor YELLOW;
    public static final UnoCardColor BLACK;

    public static final List<UnoCardColor> COLORS;

    static {
        COLORS = new ArrayList<>(); // Initialize COLORS first
        RED = new UnoCardColor("Red");
        BLUE = new UnoCardColor("Blue");
        GREEN = new UnoCardColor("Green");
        YELLOW = new UnoCardColor("Yellow");
        BLACK = new UnoCardColor("Black");
    }

    private String color;

    private UnoCardColor(String color) {
        this.color = color;
        COLORS.add(this);
    }

    public String toString() {
        return color;
    }

    // Create a new color
    public static UnoCardColor createColor(String color) {
        if (isColorExist(color)) {
            return null; // Indicate color already exists
        }
        return new UnoCardColor(color);
    }

    // Check if the color exists in the list
    public static boolean isColorExist(String color) {
        return COLORS.stream().anyMatch(c -> c.toString().equals(color)); // Use Stream for efficiency
    }

    // Get the color from the list
    public static UnoCardColor getColor(String color) {
        return COLORS.stream().filter(c -> c.toString().equals(color)).findFirst().orElse(null); // Use Stream for efficiency
    }
}