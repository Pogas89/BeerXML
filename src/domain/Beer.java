package domain;

import java.util.HashSet;

public class Beer {
    private String identity;
    private String name;
    private AlchoholType alchoholType;
    private String Manufactor;
    private HashSet<Ingridient> ingridients = new HashSet<>();
    private HashSet<Chars> chars = new HashSet<>();

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

    public AlchoholType getAlchoholType() {
        return alchoholType;
    }

    public void setAlchoholType(AlchoholType alchoholType) {
        this.alchoholType = alchoholType;
    }

    public String getManufactor() {
        return Manufactor;
    }

    public void setManufactor(String manufactor) {
        Manufactor = manufactor;
    }

    public HashSet<Ingridient> getIngridients() {
        return ingridients;
    }

    public HashSet<Chars> getChars() {
        return chars;
    }

    @Override
    public String toString() {
        String str = "";
        str += ("ID: " + getIdentity() + "\n");
        str += ("Name of Beer: " + getName() + "\n");
        str += ("Alchoholic or not alchoholic: " + getAlchoholType() + "\n");
        str += ("Manufactor: " + getManufactor() + "\n");
        for (Ingridient ingrid : getIngridients()) {
            str += (ingrid.getName() + ": " + ingrid.getValue()) + "\n";
        }
        for (Chars chars : getChars()) {
            str += (chars.getName() + ": " + chars.getValue()) + "\n";
        }
        return str;
    }
}
