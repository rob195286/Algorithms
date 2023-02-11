package sort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TestInstance permet de lancer les tests en créant un objet (test classe) et d'éviter les déclarations statiques.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SortAlgorithmsTest {
    SortAlgorithms sa = new SortAlgorithms();
    int arraySize = 100000;
    Random randInt = new Random();
    int[] array1;
    int[] array2;
    int[] array3;
    int[] array4 = new int[arraySize];
    int[] arrayToCompareWith1;
    int[] arrayToCompareWith2;
    int[] arrayToCompareWith4 = new int[arraySize];
    int[] arrayConcatenated;
    int[] arrayConcatenatedToCompareWith;

    @BeforeAll
    public void setup(){
    }
    @BeforeEach
    public void resetState(){
        array1 = new int[]{2, 6, 9, 8, 11, 23, 65, 89, 14, 47, 85};
        arrayToCompareWith1 = array1.clone();
        Arrays.sort(arrayToCompareWith1);
        array2 = new int[]{4, 8, 12, 13, 14};
        array3 = new int[]{1, 2, 6, 8, 9, 10};
        for (int i = 0; i < arraySize; i++){
            array4[i] = randInt.nextInt();
        }
        arrayToCompareWith2 = array2.clone();
        arrayToCompareWith4 = array4;
        Arrays.sort(arrayToCompareWith1);
    }

    @Test
    void insertionSort() {
        sa.insertionSort(array1);
        assertEquals(0, Arrays.compare(array1, arrayToCompareWith1));
        sa.insertionSort(array4);
        assertEquals(0, Arrays.compare(array4, arrayToCompareWith4));
    }

    @Test
    void mergeSort() {
        Arrays.sort(array2);
        Arrays.sort(array3);
        arrayConcatenated = new int[array2.length + array3.length];
        System.arraycopy(array2, 0, arrayConcatenated, 0, array2.length);
        System.arraycopy(array3, 0, arrayConcatenated, array2.length, array3.length);
        arrayConcatenatedToCompareWith = arrayConcatenated.clone();
        sa.mergeSort(arrayConcatenated);
        Arrays.sort(arrayConcatenatedToCompareWith);
        assertEquals(0, Arrays.compare(arrayConcatenatedToCompareWith, arrayConcatenated));
        //------------------------------------------------------------------------------------------------
        Arrays.sort(array3);
        Arrays.sort(array4);
        arrayConcatenated = new int[array3.length + array4.length];
        System.arraycopy(array3, 0, arrayConcatenated, 0, array3.length);
        System.arraycopy(array4, 0, arrayConcatenated, array3.length, array4.length);
        arrayConcatenatedToCompareWith = arrayConcatenated.clone();
        sa.insertionSort(arrayConcatenated);
        Arrays.sort(arrayConcatenatedToCompareWith);
        assertEquals(0, Arrays.compare(arrayConcatenatedToCompareWith, arrayConcatenated));
    }
}