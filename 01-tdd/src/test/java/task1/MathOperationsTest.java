package task1;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.BiFunction;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@FieldDefaults(level = AccessLevel.PRIVATE)
class MathOperationsTest {
    static MathOperations m;

    @Disabled
    @ParameterizedTest
    @CsvSource({"1,2,2", "3,2,6"})
    void multiply(int a, int b, int c){
        assertThat(m.multiply.apply(a,b), is(c));
    }


    @ParameterizedTest
    @CsvSource({"2,1,2", "6,2,3", "10,0,0"})
    void divide(int a, int b, double c){
        if (b == 0) {
            assertThrows(ArithmeticException.class, () -> m.divide.apply(a,b));
        } else {
            assertThat(m.divide.apply(a,b), is(c));
        }
    }

    @ParameterizedTest
    @CsvSource({"3,6","1,1", "0,1"})
    void factorial(int a, int b) {
        assertThat(m.factorial.apply(a), is(b));
    }

}