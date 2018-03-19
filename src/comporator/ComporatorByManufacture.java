package comporator;

import domain.Beer;

import java.util.Comparator;

public class ComporatorByManufacture implements Comparator<Beer> {
    public int compare(Beer obj1, Beer obj2){
        return obj1.getManufactor().compareTo(obj2.getManufactor());
    }
}
