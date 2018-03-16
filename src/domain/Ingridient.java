package domain;

public abstract class Ingridient {
    private String name;

    public Ingridient(String name) {
        this.name = name;
    }

    public abstract void setValue (String value);

    public abstract String getValue();

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }

    @Override
    public String toString() {
        return getValue();
    }
}
