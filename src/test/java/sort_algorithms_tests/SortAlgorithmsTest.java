package sort_algorithms_tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import sort_algorithms.SortAlgorithms;

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
    int[] array3 = new int[arraySize];
    int[] array1_2;
    int[] array1ToCompareWith;
    int[] array2ToCompareWith;
    int[] array3ToCompareWith = new int[arraySize];
    int[] array1_2ToCompareWith;

    @BeforeAll
    public void initialisation(){
    }
    @BeforeEach
    public void setUp(){
        array1 = new int[]{2, 6, 9, 8, 11, 23, 65, 89, 14, 47, 85};
        array2 = new int[]{0, 89, 18, 4, 8, 12, 13, 14, 21, 35, 64};
        for (int i = 0; i < arraySize; i++){
            array3[i] = randInt.nextInt();
        }
        array1_2 = new int[array1.length + array2.length];
        array1_2ToCompareWith = new int[array1.length + array2.length];
        array1ToCompareWith = array1.clone();
        array2ToCompareWith = array2.clone();
        array3ToCompareWith = array3.clone();
        Arrays.sort(array1ToCompareWith);
        Arrays.sort(array2ToCompareWith);
        Arrays.sort(array3ToCompareWith);
    }

    @Test
    void insertionSortTest() {
        sa.insertionSort(array1);
        assertEquals(0, Arrays.compare(array1, array1ToCompareWith));
        sa.insertionSort(array2);
        assertEquals(0, Arrays.compare(array2, array2ToCompareWith));
        sa.insertionSort(array3);
        assertEquals(0, Arrays.compare(array3, array3ToCompareWith));
    }

    @Test
    void mergeSortTest() {
        // TODO : mergesort, vérifier si c'est ok
        System.arraycopy(array1, 0, array1_2,0, array1.length);
        System.arraycopy(array2, 0, array1_2, array1.length, array2.length);
        array1_2ToCompareWith = array1_2.clone();
        Arrays.sort(array1_2ToCompareWith);
        sa.mergeSort(array1_2);
        assertEquals(0, Arrays.compare(array1_2ToCompareWith, array1_2));
        sa.mergeSort(array3);
        assertEquals(0, Arrays.compare(array3ToCompareWith, array3));
    }

    @Test
    void heapSort() {
        sa.heapSort(array1, array1.length);
        assertEquals(0, Arrays.compare(array1ToCompareWith, array1));
        sa.heapSort(array2, array2.length);
        assertEquals(0, Arrays.compare(array2ToCompareWith, array2));
        sa.heapSort(array3, array3.length);
        assertEquals(0, Arrays.compare(array3ToCompareWith, array3));
    }
}