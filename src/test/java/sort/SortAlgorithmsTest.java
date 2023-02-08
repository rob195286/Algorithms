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
    int[] arrayTest = {2, 6, 9, 8, 11, 23, 65, 89, 14, 47, 85};
    int[] arrayTestToCompare = arrayTest.clone();

    @BeforeAll
    public void setup(){
        Arrays.sort(arrayTestToCompare);
    }
    @BeforeEach
    public void resetState(){
        arrayTest = new int[]{2, 6, 9, 8, 11, 23, 65, 89, 14, 47, 85};

    }

    @Test
    void insertionSort() {
        sa.insertionSort(arrayTest);
        assertEquals(0, Arrays.compare(arrayTest, arrayTestToCompare));
    }

}