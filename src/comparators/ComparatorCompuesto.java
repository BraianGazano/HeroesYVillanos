package comparators;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import juego.Enfrentable;

public class ComparatorCompuesto implements Comparator<Enfrentable> {

    private List<Comparator<Enfrentable>> comparators;

    public ComparatorCompuesto() {
        this.comparators = new LinkedList<Comparator<Enfrentable>>();
    }

    public ComparatorCompuesto(List<Comparator<Enfrentable>> comparators) {
        this.comparators = comparators;
    }

    public boolean addComparator(Comparator<Enfrentable> c) {
        if (c == this) {
            return false;
        }
        return comparators.add(c);
    }

    public boolean addComparator(Comparator<Enfrentable> c, int index) {
        if (c == this) {
            return false;
        }
        comparators.add(index, c);
        return true;
    }

    @Override
    public int compare(Enfrentable e1, Enfrentable e2) {
        int result;
        for (Comparator<Enfrentable> c : comparators) {
            result = c.compare(e1, e2);
            if (result != 0)
                return result;
        }
        return 0;
    }

}
