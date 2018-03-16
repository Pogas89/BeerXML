package domain;

public class Bottling extends Chars {

    private Double volume;
    private String material;

    public Bottling() {
        super("Way of bottling");
    }

    @Override
    public void setValue(String value) {
        String[] str = (value.trim()).split("\\s",2);
        volume = Double.valueOf(str[0]);
        material = str[1];
    }

    @Override
    public String getValue() {
        return volume.toString() + " " + material;
    }
}
