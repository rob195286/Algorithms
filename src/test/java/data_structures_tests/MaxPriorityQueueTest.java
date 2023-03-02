package data_structures_tests;

import data_structures.MaxPriorityQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MaxPriorityQueueTest {
    MaxPriorityQueue maxPriorityQueue1;
    MaxPriorityQueue maxPriorityQueue2;

    @BeforeEach
    void setUp() {
        maxPriorityQueue1 = new MaxPriorityQueue(new int[]{16,4,10,13,7,9,3,2,14,1});
        maxPriorityQueue2 = new MaxPriorityQueue(new int[]{1,14,10,8,7,9,3,2,4,16});
    }

    @Test
    void maxHeapInsert() {
    }

    @Test
    void maxHeapExtractMax() {
        int pqSize = maxPriorityQueue1.getSize();
        int maxValue = maxPriorityQueue1.maxHeapExtractMax();
        assertEquals(16, maxValue);
        assertEquals(--pqSize, maxPriorityQueue1.getSize());

        pqSize = maxPriorityQueue2.getSize();
        maxValue = maxPriorityQueue2.maxHeapExtractMax();
        assertEquals(16, maxValue);
        assertEquals(--pqSize, maxPriorityQueue2.getSize());
    }

    @Test
    void maxHeapIncreaseKey() {
    }
}