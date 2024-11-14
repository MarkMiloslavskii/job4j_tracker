package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionCalculatorTest {
    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenLinearFunctionThenQuatroResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 4, x -> x * x - 2 * x + 1);
        List<Double> expected = Arrays.asList(0D, 1D, 4D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenLinearFunctionThenShowResults() {
        FunctionCalculator function = new FunctionCalculator();
        double a = 0.5;
        List<Double> result = function.diapason(5, 8, x -> x / a);
        List<Double> expected = Arrays.asList(10D, 12D, 14D);
        assertThat(result).containsAll(expected);
    }
}
