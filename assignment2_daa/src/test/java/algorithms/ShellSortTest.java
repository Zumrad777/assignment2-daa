package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShellSortTest {

    @Test
    public void testEmptyArray() {
        int[] array = {};
        int[] expected = {};
        ShellSort.sort(array, ShellSort.GapSequence.SHELL);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSingleElement() {
        int[] array = {7};
        int[] expected = {7};
        ShellSort.sort(array, ShellSort.GapSequence.SHELL);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        ShellSort.sort(array, ShellSort.GapSequence.KNUTH);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testReverseArray() {
        int[] array = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        ShellSort.sort(array, ShellSort.GapSequence.SHELL);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testWithDuplicates() {
        int[] array = {4, 2, 4, 3, 1, 2};
        int[] expected = {1, 2, 2, 3, 4, 4};
        ShellSort.sort(array, ShellSort.GapSequence.KNUTH);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSedgewickSequence() {
        int[] array = {10, 7, 8, 9, 1, 5};
        int[] expected = {1, 5, 7, 8, 9, 10};
        ShellSort.sort(array, ShellSort.GapSequence.SEDGEWICK);
        assertArrayEquals(expected, array);
    }
}
