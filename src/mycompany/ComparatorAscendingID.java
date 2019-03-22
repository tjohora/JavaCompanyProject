package mycompany;
import java.util.Comparator;

/**
 *
 * @author D00186562
 */
public class ComparatorAscendingID implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        if (o1.getId() < o2.getId()) {
            return -1;
        }
        if (o1.getId() < o2.getId()) {
            return -1;
        }
        return 0;
    }
}