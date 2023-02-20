package data_structures_tests;

import data_structures.BinaryMaxHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinaryMaxHeapTest {
    BinaryMaxHeap bh1;

    @BeforeEach
    void setUp() {
        bh1 = new BinaryMaxHeap(new int[]{16,14,10,8,7,9,3,2,4,1}, false);

    }

    @Test
    void parent() {
        int parentNode = bh1.parent(8);
        assertEquals(3, parentNode);
        parentNode = bh1.parent(5);
        assertEquals(2, parentNode);
        parentNode = bh1.parent(2);
        assertEquals(0, parentNode);
        parentNode = bh1.parent(1);
        assertEquals(0, parentNode);
    }

    @Test
    void leftChild() {
        int leftChildNode = bh1.leftChild(0);
        assertEquals(1, leftChildNode);
        leftChildNode = bh1.leftChild(4);
        assertEquals(9, leftChildNode);
        leftChildNode = bh1.leftChild(2);
        assertEquals(5, leftChildNode);
    }

    @Test
    void rightChild() {
        int rightChildNode = bh1.rightChild(0);
        assertEquals(2, rightChildNode);
        rightChildNode = bh1.rightChild(3);
        assertEquals(8, rightChildNode);
        rightChildNode = bh1.rightChild(2);
        assertEquals(6, rightChildNode);
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