package uno.game;

public class UnoSetting<T> {
    private T value;
    private T defaultValue;
    private String name;

    public UnoSetting(T value, T defaultValuet, String name) {
        this.value = value;
        this.defaultValue = defaultValue;
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    // Reset the setting to its default value
    public void reset() {
        this.value = defaultValue;
    }
}
