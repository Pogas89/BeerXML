package domain;

import java.util.HashSet;

/**
 * Beer objcet that contains information
 * about unit of goods
 */
public class Beer {
    private String identity;
    private String name;
    private BeerType beerType;
    private AlchoholType alchoholType;
    private String Manufactor;
    private Ingridient ingridients = new Ingridient();
    private Chars chars = new Chars();

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BeerType getBeerType() {
        return beerType;
    }

    public void setBeerType(BeerType beerType) {
        this.beerType = beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = BeerType.valueOf(beerType);
    }

    public AlchoholType getAlchoholType() {
        return alchoholType;
    }

    public void setAlchoholType(AlchoholType alchoholType) {
        this.alchoholType = alchoholType;
    }

    public void setAlchoholType(String alchoholType) {
        this.alchoholType = AlchoholType.valueOf(alchoholType);
    }

    public String getManufactor() {
        return Manufactor;
    }

    public void setManufactor(String manufactor) {
        Manufactor = manufactor;
    }

    public Ingridient getIngridients() {
        return ingridients;
    }

    public void setIngridients(Ingridient ingridients) {
        this.ingridients = ingridients;
    }

    public Chars getChars() {
        return chars;
    }

    public void setChars(Chars chars) {
        this.chars = chars;
    }

    @Override
    public String toString() {
        String str = "";
        str += ("ID: " + getIdentity() + "\n");
        str += ("Name of Beer: " + getName() + "\n");
        str += ("Beer type: ") + getBeerType() + "\n";
        str += ("Alchoholic or not alchoholic: " + getAlchoholType() + "\n");
        str += ("Manufactor: " + getManufactor() + "\n");
        str += ("Ingridients: " + getIngridients() +"\n");
        str += ("Characteristics: " + getChars() + "\n");
        return str;
    }
}
