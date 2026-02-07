import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class PerformanceKSorted {

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};
        int iterations = 20;

        try (PrintWriter writer = new PrintWriter(new FileWriter("performance_ksorted_results.txt"))) {

            // BubbleSort
            writer.println("Sorting algorithm – BubbleSort");
            Tester bubbleTester = new Tester(new BubbleSort());
            for (int size : sizes) {
                double avgTime = runKSortedTest(bubbleTester, iterations, size);
                writer.println("Sorted " + size + " elements in " + avgTime + " ms (avg)");
            }
            writer.println();

            // InsertionSort
            writer.println("Sorting algorithm – InsertionSort");
            Tester insertionTester = new Tester(new InsertionSort());
            for (int size : sizes) {
                double avgTime = runKSortedTest(insertionTester, iterations, size);
                writer.println("Sorted " + size + " elements in " + avgTime + " ms (avg)");
            }
            writer.println();

            // SelectionSort
            writer.println("Sorting algorithm – SelectionSort");
            Tester selectionTester = new Tester(new SelectionSort());
            for (int size : sizes) {
                double avgTime = runKSortedTest(selectionTester, iterations, size);
                writer.println("Sorted " + size + " elements in " + avgTime + " ms (avg)");
            }
            writer.println();

            // ShellSort
            writer.println("Sorting algorithm – ShellSort");
            Tester shellTester = new Tester(new ShellSort());
            for (int size : sizes) {
                double avgTime = runKSortedTest(shellTester, iterations, size);
                writer.println("Sorted " + size + " elements in " + avgTime + " ms (avg)");
            }
            writer.println();

            // QuickSort
            writer.println("Sorting algorithm – QuickSort");
            Tester quickTester = new Tester(new QuickSort());
            for (int size : sizes) {
                double avgTime = runKSortedTest(quickTester, iterations, size);
                writer.println("Sorted " + size + " elements in " + avgTime + " ms (avg)");
            }
            writer.println();

            // MergeSort
            writer.println("Sorting algorithm – MergeSort");
            Tester mergeTester = new Tester(new MergeSort());
            for (int size : sizes) {
                double avgTime = runKSortedTest(mergeTester, iterations, size);
                writer.println("Sorted " + size + " elements in " + avgTime + " ms (avg)");
            }
            writer.println();

            System.out.println("K-sorted performance test complete!");
            System.out.println("Results saved to: performance_ksorted_results.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double runKSortedTest(Tester tester, int iterations, int size) {
        double totalTime = 0.0;
        for (int i = 0; i < iterations; i++) {
            totalTime += tester.singleTestKSorted(size);
        }
        return totalTime / iterations;
    }
}