package task2;

import java.util.Iterator;
import java.util.List;

public interface Range {
    boolean isBefore(Range otherRange);
    boolean isAfter(Range otherRange);
    boolean isConcurent(Range otherRange);
    Long getLowerBound();
    Long getUpperBound();
    boolean contains(long value);
    List<Long> asList();
    Iterator<Long> asIterator();
}
