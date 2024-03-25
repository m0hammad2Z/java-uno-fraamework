package uno.card;

import java.util.ArrayList;
import java.util.List;

public class UnoCardValue {
    public static final UnoCardValue ZERO;
    public static final UnoCardValue ONE;
    public static final UnoCardValue TWO;
    public static final UnoCardValue THREE;
    public static final UnoCardValue FOUR;

    public static final UnoCardValue FIVE;

    public static final UnoCardValue SIX;

    public static final UnoCardValue SEVEN;

    public static final UnoCardValue EIGHT;

    public static final UnoCardValue NINE;

    public static final UnoCardValue DRAW_TWO;

    public static final UnoCardValue SKIP;

    public static final UnoCardValue REVERSE;

    public static final UnoCardValue WILD;

    public static final UnoCardValue WILD_DRAW_FOUR;



    public static final List<UnoCardValue> VALUES;

    static {
        VALUES = new ArrayList<>();
        ZERO = new UnoCardValue("0");
        ONE = new UnoCardValue("1");
        TWO = new UnoCardValue("2");
        THREE = new UnoCardValue("3");
        FOUR = new UnoCardValue("4");
        FIVE = new UnoCardValue("5");
        SIX = new UnoCardValue("6");
        SEVEN = new UnoCardValue("7");
        EIGHT = new UnoCardValue("8");
        NINE = new UnoCardValue("9");
        DRAW_TWO = new UnoCardValue("Draw Two");
        SKIP = new UnoCardValue("Skip");
        REVERSE = new UnoCardValue("Reverse");
        WILD = new UnoCardValue("Wild");
        WILD_DRAW_FOUR = new UnoCardValue("Wild Draw Four");
    }

    private final String value;

    public UnoCardValue(String value) {
        this.value = value;
        VALUES.add(this);
    }

    public String toString() {
        return value;
    }

    public static UnoCardValue createValue(String value) {
        if (isValueExist(value)) {
            return null;
        }
        return new UnoCardValue(value);
    }

    public static boolean isValueExist(String value) {
        return VALUES.stream().anyMatch(v -> v.toString().equals(value));
    }

    public static UnoCardValue getValue(String value) {
        return VALUES.stream().filter(v -> v.toString().equals(value)).findFirst().orElse(null);
    }



}
