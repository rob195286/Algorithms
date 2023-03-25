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
    double[] array1F;
    int[] array2;
    double[] array2F;
    int[] array3 = new int[arraySize];
    double[] array3F = new double[arraySize];
    int[] array1_2;
    int[] array1ToCompareWith;
    double[] array1FToCompareWith;
    int[] array2ToCompareWith;
    double[] array2FToCompareWith;
    int[] array3ToCompareWith = new int[arraySize];
    double[] array3FToCompareWith = new double[arraySize];
    int[] array1_2ToCompareWith;

    @BeforeAll
    public void initialisation(){
    }
    @BeforeEach
    public void setUp(){
        array1 = new int[]{2, 6, 9, 8, 11, 23, 65, 89, 14, 47, 85};
        array1F = new double[]{.2, .6, .9, .8, .11, .23, .65, .89, .14, .47, .85};
        array2 = new int[]{0, 89, 18, 4, 8, 12, 13, 14, 21, 35, 64};
        array2F = new double[]{.0, .89, .18, .4, .8, .12, .13, .14, .21, .35, .64};
        for (int i = 0; i < arraySize; i++){
            array3[i] = randInt.nextInt(0, arraySize);
        }
        for (int i = 0; i < arraySize; i++){
            array3F[i] = randInt.nextDouble(0, arraySize);
        }
        array1_2 = new int[array1.length + array2.length];
        array1_2ToCompareWith = new int[array1.length + array2.length];
        array1ToCompareWith = array1.clone();
        array1FToCompareWith = array1F.clone();
        array2ToCompareWith = array2.clone();
        array2FToCompareWith = array2F.clone();
        array3ToCompareWith = array3.clone();
        array3FToCompareWith = array3F.clone();
        Arrays.sort(array1ToCompareWith);
        Arrays.sort(array1FToCompareWith);
        Arrays.sort(array2ToCompareWith);
        Arrays.sort(array2FToCompareWith);
        Arrays.sort(array3ToCompareWith);
        Arrays.sort(array3FToCompareWith);
    }

    @Test
    void insertionSort() {
        sa.insertionSort(array1);
        assertEquals(0, Arrays.compare(array1, array1ToCompareWith));
        sa.insertionSort(array2);
        assertEquals(0, Arrays.compare(array2, array2ToCompareWith));
        sa.insertionSort(array3);
        assertEquals(0, Arrays.compare(array3, array3ToCompareWith));
    }

    @Test
    void mergeSort() {
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

    @Test
    void countingSort() {
        int heighestVal = array1ToCompareWith[array1ToCompareWith.length-1];
        assertEquals(0, Arrays.compare(array1ToCompareWith, sa.countingSort(array1, heighestVal)));

        heighestVal = array2ToCompareWith[array2ToCompareWith.length-1];
        assertEquals(0, Arrays.compare(array2ToCompareWith, sa.countingSort(array2, heighestVal)));

        heighestVal = array3ToCompareWith[array3ToCompareWith.length-1];
        assertEquals(0, Arrays.compare(array3ToCompareWith, sa.countingSort(array3, heighestVal)));
    }

    @Test
    void bucketSort() {
       // int n = 10;
        // todo : continuer
        /*
        sa.bucketSort(array1F, n);
        assertEquals(0, Arrays.compare(array1FToCompareWith, array1F));
        sa.bucketSort(array2F, n);
        assertEquals(0, Arrays.compare(array2FToCompareWith, array2F));
        sa.bucketSort(array3F, n);
        assertEquals(0, Arrays.compare(array3FToCompareWith, array3F));

         */
    }
}