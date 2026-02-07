import java.util.Random;

public class KSortedGenerator {

    public static void generateKSorted(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i;
        }

        Random rand = new Random();
        for (int i = 0; i < myArray.length; i++) {
            int maxOffset = Math.min(10, myArray.length - i - 1);

            int swapIndex = i + rand.nextInt(maxOffset + 1);

            int temp = myArray[i];
            myArray[i] = myArray[swapIndex];
            myArray[swapIndex] = temp;
        }
    }
}