package domain;

public class NutritiveValue extends Chars {

    private Integer value;

    public NutritiveValue() {
        super("Nutritive Value");
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
