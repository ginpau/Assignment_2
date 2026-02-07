public class BubbleSort implements SortingAlgorithm{
    @Override
    public int[] sorty(int[] input){

        int[] arrayList = new int[input.length];
        for(int i = 0; i < input.length; i++){
            arrayList[i] = input[i];
        }

        int n = arrayList.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
              if(arrayList[j] > arrayList[j+1]){
                  int temp = arrayList[j];
                  arrayList[j] = arrayList[j+1];
                  arrayList[j+1] = temp;
              }
            }
        }

        return arrayList;
    }
}
