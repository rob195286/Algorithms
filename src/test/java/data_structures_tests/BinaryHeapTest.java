package data_structures_tests;

import data_structures.BinaryHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinaryHeapTest {
    BinaryHeap bh1;

    @BeforeEach
    void setUp() {
        bh1 = new BinaryHeap(new int[]{16,14,10,8,7,9,3,2,4,1}, false);

    }

    @Test
    void parent() {
        int parentNode = bh1.parent(2);
        assertEquals(14, parentNode);
        parentNode = bh1.parent(1);
        assertEquals(16, parentNode);
        parentNode = bh1.parent(0);
        assertEquals(16, parentNode);
    }

    @Test
    void leftChild() {
        int leftChildNode = bh1.leftChild(0);
        assertEquals(14, leftChildNode);
        leftChildNode = bh1.leftChild(4);
        assertEquals(1, leftChildNode);
        leftChildNode = bh1.leftChild(2);
        assertEquals(9, leftChildNode);
    }

    @Test
    void rightChild() {
        int rightChildNode = bh1.rightChild(0);
        assertEquals(10, rightChildNode);
        rightChildNode = bh1.rightChild(3);
        assertEquals(4, rightChildNode);
        rightChildNode = bh1.rightChild(2);
        assertEquals(3, rightChildNode);
    }

    @Test
    void maxHeapify() {
    }

    @Test
    void buildMaxHeap() {
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
    }

    @Test
    void getSize() {
        assertEquals(10, bh1.getSize());
    }

    @Test
    void getLength() {
        assertEquals(10, bh1.getLength());
    }
}