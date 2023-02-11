package sort;


public class SortAlgorithms {
    public void insertionSort(int[] arrayToSort){
        int value;
        int j;
        for (int i = 1; i < arrayToSort.length; i++){
            value = arrayToSort[i];
            j = i-1;
            while(j > -1 && arrayToSort[j] > value){
                arrayToSort[j+1] = arrayToSort[j]; // Echange les valeurs si celle de gauche dans l'array est <.
                j--;                               // Désincrémente j pour pouvoir parcourir l'array vers la gauche.
            }
            arrayToSort[j+1] = value;
        }
    }
    public void mergeSort(int[] arrayToSort){
        this.mergeSort(arrayToSort, 0, arrayToSort.length-1);
    }
    private void mergeSort(int[] arrayToSort, int p, int r){
        if(p >= r)
            return;
        int q = (p + r)/2;
        mergeSort(arrayToSort, p, q);
        mergeSort(arrayToSort , q+1, arrayToSort.length/2);
        //------------------------------------------------------- Merge
        int leftSize = q-p+1;
        int rightSize = r-q;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        int i, j, k = p;
        for (i = 0; i < leftSize; i++) {
            leftArray[i] = arrayToSort[p+i];
        }
        for (j = 0; j < rightSize; j++) {
            rightArray[j] = arrayToSort[q+j+1];
        }
        i = 0;
        j = 0;
        while (i < leftSize && j < rightSize){
            if(leftArray[i] <= rightArray[j]) {
                arrayToSort[k] = leftArray[i];
                i++;
            }
            else {
                arrayToSort[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < leftSize){
            arrayToSort[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightSize){
            arrayToSort[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
