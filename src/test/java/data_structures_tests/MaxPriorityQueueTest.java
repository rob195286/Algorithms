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
    void maxPriorityQueueBuilding() {
        // todo : voir comment tester
       // assertEquals(0,maxPriorityQueue.);
    }

    @Test
    void maxHeapInsert() {
    }

    @Test
    void maxHeapExtractMax() {
    }

    @Test
    void maxHeapIncreaseKey() {
    }

    @Test
    void maxHeapMaximum() {
        assertEquals(16,maxPriorityQueue1.maxHeapMaximum());
        assertEquals(16,maxPriorityQueue2.maxHeapMaximum());
    }
}