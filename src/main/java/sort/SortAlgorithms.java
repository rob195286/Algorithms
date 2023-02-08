package sort;

public class SortAlgorithms {
    public void insertionSort(int[] arrayToSort){
        int value;
        int j;
        for (int i = 1; i < arrayToSort.length; i++){
            value = arrayToSort[i];
            j = i-1;
            while(j > -1 && arrayToSort[j] > value){
                arrayToSort[j+1] = arrayToSort[j];
                j--;
            }
            arrayToSort[j+1] = value;
        }
    }
}
