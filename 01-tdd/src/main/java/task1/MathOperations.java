package task1;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.BiFunction;
import java.util.function.Function;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class MathOperations {
    static BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a*b;

    static Function<Integer, Integer> factorial =
            (a) -> a != 0 ? a * MathOperations.factorial.apply(a-1) : 1;

    static BiFunction<Integer, Integer, Double> divide = (a, b) -> Double.valueOf(a/b);

}
