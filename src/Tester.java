import java.util.Random;

public class Tester {

    private SortingAlgorithm algorithm;

    public Tester(SortingAlgorithm sa) {
        this.algorithm = sa;
    }

    public double singleTest(int size) {
        int[] array = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt();
        }

        long startTime = System.nanoTime();

        algorithm.sorty(array);

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000.0;
    }

    public void test(int iterations, int size) {
        double totalTime = 0.0;

        for (int i = 0; i < iterations; i++) {
            totalTime += singleTest(size);
        }

        double averageTime = totalTime / iterations;

        System.out.println(
                algorithm.getClass().getSimpleName() +
                        " | Size: " + size +
                        " | Iterations: " + iterations +
                        " | Avg Time: " + averageTime + " ms"
        );
    }


    public double singleTestKSorted(int size) {
        int[] array = new int[size];

        KSortedGenerator.generateKSorted(array);

        long startTime = System.nanoTime();

        algorithm.sorty(array);

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000.0;
    }

    public void testKSorted(int iterations, int size) {
        double totalTime = 0.0;

        for (int i = 0; i < iterations; i++) {
            totalTime += singleTestKSorted(size);
        }

        double averageTime = totalTime / iterations;

        System.out.println(
                algorithm.getClass().getSimpleName() +
                        " | Size: " + size +
                        " | Iterations: " + iterations +
                        " | Avg Time: " + averageTime + " ms"
        );
    }
}