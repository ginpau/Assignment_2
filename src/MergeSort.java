// MergeSort.java
public class MergeSort implements SortingAlgorithm {

    @Override
    public int[] sorty(int[] input) {
        int[] arrayList = new int[input.length];
        for (int i = 0; i < input.length; i++) arrayList[i] = input[i];

        mergesort(arrayList, 0, arrayList.length - 1);
        return arrayList;
    }

    private void mergesort(int[] arrayList, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergesort(arrayList, left, mid);
            mergesort(arrayList, mid + 1, right);
            merge(arrayList, left, mid, right);
        }
    }

    private void merge(int[] arrayList, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arrayList[left + i];
        for (int j = 0; j < n2; j++) R[j] = arrayList[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arrayList[k++] = L[i++];
            else arrayList[k++] = R[j++];
        }

        while (i < n1) arrayList[k++] = L[i++];
        while (j < n2) arrayList[k++] = R[j++];
    }
}
