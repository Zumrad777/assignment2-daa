package algorithms;

import java.util.ArrayList;
import java.util.List;

public class ShellSort {

    public enum GapSequence {
        SHELL, KNUTH, SEDGEWICK
    }

    public static void sort(int[] arr, GapSequence sequence) {
        int[] gaps = getGaps(arr.length, sequence);

        for (int gap : gaps) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    private static int[] getGaps(int n, GapSequence seq) {
        switch (seq) {
            case KNUTH:
                return knuthGaps(n);
            case SEDGEWICK:
                return sedgewickGaps(n);
            default:
                return shellGaps(n);
        }
    }

    private static int[] shellGaps(int n) {
        int gap = n / 2;
        List<Integer> gaps = new ArrayList<>();
        while (gap > 0) {
            gaps.add(gap);
            gap /= 2;
        }
        return gaps.stream().mapToInt(i -> i).toArray();
    }

    private static int[] knuthGaps(int n) {
        List<Integer> gaps = new ArrayList<>();
        int h = 1;
        while (h < n) {
            gaps.add(0, h);
            h = 3 * h + 1;
        }
        return gaps.stream().mapToInt(i -> i).toArray();
    }

    private static int[] sedgewickGaps(int n) {
        List<Integer> gaps = new ArrayList<>();
        int k = 0;
        int gap;
        while (true) {
            if (k % 2 == 0) {
                gap = (int) (9 * (Math.pow(2, k) - Math.pow(2, k / 2)) + 1);
            } else {
                gap = (int) (8 * Math.pow(2, k) - 6 * Math.pow(2, (k + 1) / 2) + 1);
            }
            if (gap >= n) break;
            gaps.add(0, gap);
            k++;
        }
        return gaps.stream().mapToInt(i -> i).toArray();
    }

    public static void sort(int[] arr) {
        sort(arr, GapSequence.SHELL);
    }
}
