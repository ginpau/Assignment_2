public class ShellSort implements SortingAlgorithm{
    @Override
    public int[] sorty(int[] input){
        int[] arrayList = new int[input.length];
        for(int i = 0; i < input.length; i++){
            arrayList[i] = input[i];
        }

        int n = arrayList.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arrayList[i];
                int j = i;
                while (j >= gap && arrayList[j - gap] > temp) {
                    arrayList[j] = arrayList[j - gap];
                    j -= gap;
                }
                arrayList[j] = temp;
            }
        }
        return arrayList;
    }
}
