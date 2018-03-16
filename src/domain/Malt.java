package domain;

public class Malt extends Ingridient {
    private Integer value;

    public Malt() {
        super("Malt");
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
