package domain;

public class Bottling {

    private Double volume;
    private String material;

    public void setValue(String value) {
        String[] str = (value.trim()).split("\\s",2);
        volume = Double.valueOf(str[0]);
        material = str[1];
    }

    public String getValue() {
        return volume + " " + material;
    }
}
