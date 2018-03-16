package domain;

public class Filtration extends Chars{

    private FiltrationType filtration;

    public Filtration() {
        super("Filtration");
    }

    @Override
    public void setValue(String value) {
        filtration = FiltrationType.valueOf(value);
    }

    @Override
    public String getValue() {
        return filtration.toString();
    }
}
