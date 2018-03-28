package domain;

public class Chars {
    SpiritAmount spiritAmount = new SpiritAmount();
    Transparency transparency = new Transparency();
    Filtration filtration = new Filtration();
    NutritiveValue nutritiveValue = new NutritiveValue();
    Bottling bottling = new Bottling();

    public SpiritAmount getSpiritAmount() {
        return spiritAmount;
    }

    public void setSpiritAmount(SpiritAmount spiritAmount) {
        this.spiritAmount = spiritAmount;
    }

    public Transparency getTransparency() {
        return transparency;
    }

    public void setTransparency(Transparency transparency) {
        this.transparency = transparency;
    }

    public Filtration getFiltration() {
        return filtration;
    }

    public void setFiltration(Filtration filtration) {
        this.filtration = filtration;
    }

    public NutritiveValue getNutritiveValue() {
        return nutritiveValue;
    }

    public void setNutritiveValue(NutritiveValue nutritiveValue) {
        this.nutritiveValue = nutritiveValue;
    }

    public Bottling getBottling() {
        return bottling;
    }

    public void setBottling(Bottling bottling) {
        this.bottling = bottling;
    }

    @Override
    public String toString() {
        String str="\n";
        str +=("\tSpiritAmount: " + spiritAmount.getValue() +"\n");
        str +=("\tTransparency: " + transparency.getValue() +"\n");
        str +=("\tFiltration: " + filtration.getFiltration() +"\n");
        str +=("\tNutritive Value: " + nutritiveValue.getValue() +"\n");
        str +=("\tBottling: " + bottling.getValue() +"\n");
        return str;
    }
}
