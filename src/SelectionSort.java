public class SelectionSort implements SortingAlgorithm{
    @Override
    public int[] sorty(int[] input){
        int[] arrayList = new int[input.length];
        for(int i = 0; i < input.length; i++){
            arrayList[i] = input[i];
        }

        int n = arrayList.length;
        for(int i = 0; i < n -1; i++){
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(arrayList[j] < arrayList[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arrayList[minIndex];
            arrayList[minIndex] = arrayList[i];
            arrayList[i] = temp;
        }
        return arrayList;
    }
}
