package data_structures_tests;

import data_structures.MaxPriorityQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.security.InvalidKeyException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MaxPriorityQueueTest {
    MaxPriorityQueue maxPriorityQueue1;
    MaxPriorityQueue maxPriorityQueue2;

    @BeforeEach
    void setUp() {
        maxPriorityQueue1 = new MaxPriorityQueue(new int[]{16,14,10,8,7,9,3,2,4,1});
        maxPriorityQueue2 = new MaxPriorityQueue(new int[]{1,14,10,8,7,9,3,2,4,16});
    }

    @Test
    void enqueue() {
        try {
            maxPriorityQueue1.enqueue(50);
            assertEquals(50, maxPriorityQueue1.extractMax());
            assertEquals(16, maxPriorityQueue1.extractMax());
            assertEquals(14, maxPriorityQueue1.extractMax());
            maxPriorityQueue1.extractMax();
            assertEquals(9, maxPriorityQueue1.extractMax());
            maxPriorityQueue1.extractMax();
            assertEquals(7, maxPriorityQueue1.extractMax());
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void extractMax() {
        int pqSize = maxPriorityQueue1.getSize();
        int maxValue = maxPriorityQueue1.extractMax();
        assertEquals(16, maxValue);
        assertEquals(--pqSize, maxPriorityQueue1.getSize());

        pqSize = maxPriorityQueue2.getSize();
        maxValue = maxPriorityQueue2.extractMax();
        assertEquals(16, maxValue);
        assertEquals(--pqSize, maxPriorityQueue2.getSize());
    }
    @Test
    void increaseKey() {
        try {
            maxPriorityQueue1.increaseKey(8, 18);
            assertEquals(18, maxPriorityQueue1.extractMax());
            assertEquals(16, maxPriorityQueue1.extractMax());
            assertEquals(14, maxPriorityQueue1.extractMax());
            maxPriorityQueue1.extractMax();
            maxPriorityQueue1.extractMax();
            assertEquals(8, maxPriorityQueue1.extractMax());
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void enqueuAndDequeue() {
        try {
            maxPriorityQueue1.enqueue(50);
            assertEquals(50, maxPriorityQueue1.extractMax());
            assertEquals(16, maxPriorityQueue1.extractMax());
            maxPriorityQueue1.enqueue(65);
            assertEquals(65, maxPriorityQueue1.extractMax());
            assertEquals(14, maxPriorityQueue1.extractMax());
            maxPriorityQueue1.enqueue(52);
            maxPriorityQueue1.enqueue(53);
            assertEquals(53, maxPriorityQueue1.extractMax());
            assertEquals(52, maxPriorityQueue1.extractMax());
            assertEquals(8, maxPriorityQueue1.getSize());
            assertEquals(11, maxPriorityQueue1.getLength());
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}