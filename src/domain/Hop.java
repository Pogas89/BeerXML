package domain;

public class Hop extends Ingridient {
    private Integer value;

    public Hop() {
        super("Hop");
    }

    @Override
    public void setValue(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }
}
