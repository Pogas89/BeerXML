package domain;

public class Ingridient {
    private Water water = new Water();
    private Hop hop = new Hop();
    private Malt malt = new Malt();
    private Sugar sugar = new Sugar();

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

    public Hop getHop() {
        return hop;
    }

    public void setHop(Hop hop) {
        this.hop = hop;
    }

    public Malt getMalt() {
        return malt;
    }

    public void setMalt(Malt malt) {
        this.malt = malt;
    }

    public Sugar getSugar() {
        return sugar;
    }

    public void setSugar(Sugar sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        String str="\n";
        str+=("\twater=" + water.getValue() + "\n");
        str +=("\thop=" + hop.getValue() + "\n");
        str +=("\tmalt=" + malt.getValue() + "\n");
        str +=("\tsugar=" + sugar.getValue());
        return str;
    }
}
