package domain;

public class SpiritAmount extends Chars {

    private Double value;

    public SpiritAmount() {
        super("Spirit Amount");
    }

    @Override
    public void setValue(String value) {
        this.value = Double.parseDouble(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }
}
