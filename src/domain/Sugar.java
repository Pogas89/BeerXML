package domain;

public class Sugar extends Ingridient {
    private Integer value;

    public Sugar(String name) {
        super("Sugar");
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
