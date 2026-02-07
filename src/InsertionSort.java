public class InsertionSort implements SortingAlgorithm{
    @Override
    public int[] sorty(int[] input){

        int arrayList[] = new int[input.length];
        for(int i = 0; i < input.length; i++){
            arrayList[i] = input[i];
        }

        int n = arrayList.length;
        for(int i = 1; i < n; i++){
            int key = arrayList[i];
            int j = i-1;
            while(j >= 0 && arrayList[j] > key){
                arrayList[j+1] = arrayList[j];
                j--;
            }
            arrayList[j+1] = key;
        }

        return arrayList;
    }
}
