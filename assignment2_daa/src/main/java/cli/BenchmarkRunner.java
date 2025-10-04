package cli;

import algorithms.ShellSort;
import metrics.PerformanceTracker;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        ShellSort.GapSequence[] sequences = {
                ShellSort.GapSequence.SHELL,
                ShellSort.GapSequence.KNUTH,
                ShellSort.GapSequence.SEDGEWICK
        };

        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + File.separator + "docs" + File.separator + "benchmark-results.csv";
        new File(projectPath + File.separator + "docs").mkdirs();

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Gap Sequence,Array Size,Time (ns),Comparisons,Swaps\n");

            for (ShellSort.GapSequence seq : sequences) {
                System.out.println("\n=== " + seq + " GAP SEQUENCE ===");
                for (int n : sizes) {
                    int[] arr = generateArray(n);
                    PerformanceTracker tracker = new PerformanceTracker();
                    ShellSort sorter = new ShellSort();

                    tracker.start();
                    sorter.sort(arr, seq);
                    tracker.stop();

                    writer.write(String.format("%s,%d,%d,%d,%d\n",
                            seq, n, tracker.getElapsedTime(), tracker.getComparisons(), tracker.getSwaps()));

                    System.out.printf("n=%-8d time=%-12d ns comparisons=%-8d swaps=%-8d%n",
                            n, tracker.getElapsedTime(), tracker.getComparisons(), tracker.getSwaps());
                }
            }

            System.out.println("\n Benchmark results saved to: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] generateArray(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = r.nextInt(100000);
        return arr;
    }
}
