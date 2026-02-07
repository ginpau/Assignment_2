// QuickSort.java
public class QuickSort implements SortingAlgorithm {

    @Override
    public int[] sorty(int[] input) {
        int[] arrayList = new int[input.length];
        for (int i = 0; i < input.length; i++) arrayList[i] = input[i];

        quicksort(arrayList, 0, arrayList.length - 1);
        return arrayList;
    }

    private void quicksort(int[] arrayList, int low, int high) {
        if (low < high) {
            int pi = partition(arrayList, low, high);
            quicksort(arrayList, low, pi - 1);
            quicksort(arrayList, pi + 1, high);
        }
    }

    private int partition(int[] arrayList, int low, int high) {
        int pivot = arrayList[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arrayList[j] <= pivot) {
                i++;
                int temp = arrayList[i];
                arrayList[i] = arrayList[j];
                arrayList[j] = temp;
            }
        }
        int temp = arrayList[i + 1];
        arrayList[i + 1] = arrayList[high];
        arrayList[high] = temp;
        return i + 1;
    }
}
