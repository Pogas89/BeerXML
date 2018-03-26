package comporator;

import domain.Beer;

import java.util.Comparator;

/**
 * Maid to compare two Beer objects by manufactor
 */
public class ComporatorByManufacture implements Comparator<Beer> {
    public int compare(Beer obj1, Beer obj2){
        return obj1.getManufactor().compareTo(obj2.getManufactor());
    }
}
