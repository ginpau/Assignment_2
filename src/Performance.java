import java.io.FileWriter;
import java.io.IOException;

public class Performance {

    public static void main(String[] args) {

        int iterations = 20;
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        SortingAlgorithm[] algorithms = {
                new BubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new ShellSort(),
                new QuickSort(),
                new MergeSort()
        };

        try (FileWriter writer = new FileWriter("performance_report.txt")) {

            for (SortingAlgorithm algo : algorithms) {

                writer.write("Sorting algorithm – "
                        + algo.getClass().getSimpleName() + "\n");

                Tester tester = new Tester(algo);

                for (int size : sizes) {

                    double totalTime = 0.0;

                    for (int i = 0; i < iterations; i++) {
                        totalTime += tester.singleTest(size);
                    }

                    double avgTime = totalTime / iterations;

                    writer.write("Sorted " + size +
                            " elements in " +
                            avgTime + " ms (avg)\n");
                }

                writer.write("\n");
            }

            System.out.println("Performance report generated: performance_report.txt");

        } catch (IOException e) {
            System.out.println("Error writing performance report.");
            e.printStackTrace();
        }
    }
}
