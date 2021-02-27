package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalcFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CalcFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquadFunctionThenSquadResults() {
        List<Double> result = CalcFunction.diapason(2, 5, x -> x * x + 3 * x);
        List<Double> expected = Arrays.asList(10D, 18D, 28D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExpFunctionThenExpResults() {
        List<Double> result = CalcFunction.diapason(3, 6, x -> Math.pow(2, x) - 1);
        List<Double> expected = Arrays.asList(7D, 15D, 31D);
        assertThat(result, is(expected));
    }
}