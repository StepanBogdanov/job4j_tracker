package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {

    @Test
    public void whenMatrixToList() {
        Integer[][] matrix = {{1, 2, 3}, {4, 5}};
        List<Integer> rsl = MatrixToList.matrixToList(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(rsl, is(expected));

    }
}