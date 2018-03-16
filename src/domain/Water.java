package domain;

public class Water extends Ingridient {

    private Integer value;

    public Water() {
        super("Water");
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
