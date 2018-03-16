package domain;

public class Transparency extends Chars{

    Integer value;

    public Transparency() {
        super("Transparency");
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
