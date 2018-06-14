package task2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RangeImpl implements Range {
    Long lowerBound;
    Long upperBound;

    @Override
    public boolean isAfter(Range otherRange) {
        return otherRange.getUpperBound() < lowerBound;
    }

    @Override
    public boolean isBefore(Range otherRange) {
        return otherRange.getLowerBound() > upperBound;
    }

    @Override
    public boolean isConcurent(Range otherRange) {
        return otherRange.getLowerBound() == lowerBound
                && otherRange.getUpperBound() == upperBound;
    }

    @Override
    public Iterator<Long> asIterator() {
        return new Iterator<Long>() {
            int currentId = 0;
            List<Long> lst = new RangeImpl(lowerBound, upperBound).asList();
            @Override
            public boolean hasNext() {
                return currentId < lst.size() && lst.get(currentId) != null;
            }

            @Override
            public Long next() {
                return lst.get(currentId);
            }
        };
    }

    @Override
    public List<Long> asList() {
        return LongStream.range(lowerBound,upperBound).boxed().collect(Collectors.toList());
    }

    @Override
    public boolean contains(long value) {
        return LongStream.range(lowerBound,upperBound).anyMatch((x) -> x == value);
    }
}
