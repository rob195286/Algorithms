package sort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TestInstance permet de lancer les tests en créant un objet (test classe) et d'éviter les déclarations statiques.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SortAlgorithmsTest {
    SortAlgorithms sa = new SortAlgorithms();
    int[] arrayTest1;
    int[] arrayTest2;
    int[] arrayTest3;
    int[] array2_3concatenated;
    int[] array2_3concatenatedToCompare;
    int[] arrayTestToCompare;

    @BeforeAll
    public void setup(){
    }
    @BeforeEach
    public void resetState(){
        arrayTest1 = new int[]{2, 6, 9, 8, 11, 23, 65, 89, 14, 47, 85};
        arrayTestToCompare = arrayTest1.clone();
        Arrays.sort(arrayTestToCompare);
        arrayTest2 = new int[]{4, 8, 12, 13, 14};
        arrayTest3 = new int[]{1, 2, 6, 8, 9, 10};
    }

    @Test
    void insertionSort() {
        sa.insertionSort(arrayTest1);
        assertEquals(0, Arrays.compare(arrayTest1, arrayTestToCompare));
    }

    @Test
    void mergeSort() {
        sa.insertionSort(arrayTest2);
        sa.insertionSort(arrayTest3);
        array2_3concatenated = new int[arrayTest2.length + arrayTest3.length];
        System.arraycopy(arrayTest2, 0, array2_3concatenated, 0, arrayTest2.length);
        System.arraycopy(arrayTest3, 0, array2_3concatenated, arrayTest2.length, arrayTest3.length);
        array2_3concatenatedToCompare = array2_3concatenated.clone();
        sa.mergeSort(array2_3concatenated);
        Arrays.sort(array2_3concatenatedToCompare);
        assertEquals(0, Arrays.compare(array2_3concatenatedToCompare, array2_3concatenated));
    }
}