package task2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class RangeTest {
    Range r;

    @BeforeEach
    void setUp() {
       r = new RangeImpl(1l,4l);
    }

    @Test
    void getList(){
        List<Long> res = List.of(1l,2l,3l);
        assertThat(r.asList(), is(res));
    }

    @Test
    void isBefore(){
        Range after = new RangeImpl(9l, 13l);
        assertThat(r.isBefore(after), is(true));
    }

    @Test
    void isAfter() {
        Range before = new RangeImpl(-3l,-1l);
        assertThat(r.isAfter(before), is(true));
    }

    @ParameterizedTest
    @CsvSource({"1,true", "6,false", "4,false"})
    void contains(long a, boolean res){
        assertThat(r.contains(a), is(res));
    }

    @Test
    void isConcurent() {
        Range concurent = new RangeImpl(1l,4l);
        assertThat(r.isConcurent(concurent), is(true));
    }

    @Test
    void asIterator() {
        assertAll(
                ()-> assertThat(r.asIterator() instanceof Iterator, is(true)),
                () -> assertThat(r.asIterator().next(), is(1l))
        );
    }
}