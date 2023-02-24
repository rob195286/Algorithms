package data_structures_tests;

import data_structures.BinaryMaxHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinaryMaxHeapTest {
    BinaryMaxHeap bh1;
    BinaryMaxHeap bh2;

    @BeforeEach
    void setUp() {
        bh1 = new BinaryMaxHeap(new int[]{16,14,10,8,7,9,3,2,4,1}, false);
        bh2 = new BinaryMaxHeap(new int[]{1,14,10,8,7,9,3,2,4,16}, false);
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
        int leftChildIndex = bh1.leftChild(0);
        assertEquals(1, leftChildIndex);
        leftChildIndex = bh1.leftChild(4);
        assertEquals(9, leftChildIndex);
        leftChildIndex = bh1.leftChild(2);
        assertEquals(5, leftChildIndex);
    }

    @Test
    void rightChild() {
        int rightChildIndex = bh1.rightChild(0);
        assertEquals(2, rightChildIndex);
        rightChildIndex = bh1.rightChild(2);
        assertEquals(6, rightChildIndex);
        rightChildIndex = bh1.rightChild(3);
        assertEquals(8, rightChildIndex);
    }

    @Test
    void maxHeapify() {
        // todo : ajouter un insert à la palce
        bh2.maxHeapify(0);
        /*
        assertEquals(14, bh2.getNodeAtIndex(0));
        assertEquals(8, bh2.getNodeAtIndex(bh2.leftChild(0)));
        assertEquals(10, bh2.getNodeAtIndex(bh2.rightChild(0)));
         */
    }

    @Test
    void buildMaxHeap() {
        assertEquals(true, bh1.equals(bh2));
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