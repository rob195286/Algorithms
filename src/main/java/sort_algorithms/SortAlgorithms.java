package sort_algorithms;


import data_structures.BinaryMaxHeap;

public class SortAlgorithms {
    public void insertionSort(int[] arrayToSort){
        int value;
        int j;
        for (int i = 1; i < arrayToSort.length; i++){
            value = arrayToSort[i];
            j = i-1;
            while(j > -1 && arrayToSort[j] > value){
                arrayToSort[j+1] = arrayToSort[j]; // Echange les valeurs si celle de gauche dans l'array est <.
                j--;                               // Désincrémente j pour pouvoir parcourir l'array vers la gauche
            }                                      //   et insérer la valeur en cours de traitement à son bon emplacement.
            arrayToSort[j+1] = value;   // Ajoute la valeur en cours de traitement une case avant la dernière traitée.
        }
    }
    public void mergeSort(int[] arrayToSort){
        this.mergeSort(arrayToSort, 0, arrayToSort.length-1);
    }
    private void mergeSort(int[] arrayToSort, int start, int end){
        if(start >= end)
            return;                                   // Termine l'appel récursif si on a un array dont la taille est 1.
        int middle = (start + end)/2;
        mergeSort(arrayToSort, start, middle);        // Opère l'algorithme sur la première moitié d'array.
        mergeSort(arrayToSort , middle+1, end);  // Pareil sur la seconde moitié.
        //------------------------------------------------------- Merge
        //------------------------------------------------------- Se charge de fusionner les deux array dans le bonne ordre.
        int leftSize = middle-start+1;
        int rightSize = end-middle;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        int i, j, k = start;
        for (i = 0; i < leftSize; i++) {             // Rempli l'array de gauche avec la première moitié de l'array original.
            leftArray[i] = arrayToSort[start+i];
        }
        for (j = 0; j < rightSize; j++) {           // Pareil pour celui de droite.
            rightArray[j] = arrayToSort[middle+1+j];
        }
        i = 0;
        j = 0;
        // Boucle permettant de prendre tous les éléments d'un des arrays et de les ranger dans l'ordre dans celui de base.
        while (i < leftSize && j < rightSize){
            if(leftArray[i] <= rightArray[j]) {
                arrayToSort[k] = leftArray[i];      // Si le prochain élément de l'array est gauche est < à celui de droite,
                i++;                                //      alors on le range dans le prochain emplecement (k).
            }
            else {
                arrayToSort[k] = rightArray[j];     // Si la condition plus haut n'est pas validé, c'est que la prochaine
                j++;                                //      valeur de l'array de droite est plus petite.
            }
            k++;
        }
        // Les deux boucles while se charge de trier les derniers éléments restants des deux arrays dans le bonne ordre
        //      dans l'array initial.
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
    public void heapSort(int[] arrayToSort, int arraySizeToSort){
        BinaryMaxHeap bh = new BinaryMaxHeap(arrayToSort);
        for (int i = arraySizeToSort - 1; i >= 1; i--){
            int tempNode = bh.getNodeAtIndex(0);
            bh.replaceNodeAtIndexBy(0, bh.getNodeAtIndex(i));
            bh.replaceNodeAtIndexBy(i, tempNode);
            bh.decrementSize();
            bh.maxHeapify(0);
        }
    }
}
