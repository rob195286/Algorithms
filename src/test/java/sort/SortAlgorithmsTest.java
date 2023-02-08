package sort;

import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class SortAlgorithmsTest {
    SortAlgorithms sa = new SortAlgorithms();
    int[] arrayTest = new int[]{2, 6, 9, 8, 11, 23, 65, 89, 14, 47, 85};
    int[] arrayTestToCompare = arrayTest.clone();

    @BeforeTest
    public void init(){
        arrayTest = new int[]{2, 6, 9, 8, 11, 23, 65, 89, 14, 47, 85};

    }
    @Test
    void insertionSort() {
        sa.insertionSort(arrayTest);
        assertEquals(0, Arrays.compare(arrayTest, arrayTestToCompare));
    }

}