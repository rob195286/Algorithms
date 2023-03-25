package data_structures;

import util.ExceptionsMessages;
import java.security.InvalidKeyException;


public class MaxPriorityQueue {
    private final BinaryMaxHeap binaryMaxHeap;

    public MaxPriorityQueue(int[] arraytoConvertInMaxPriorityQueue){
        binaryMaxHeap = new BinaryMaxHeap(arraytoConvertInMaxPriorityQueue);
    }

    public void enqueue(int keyToInsert) throws InvalidKeyException {
        binaryMaxHeap.addKey(keyToInsert);
        increaseKey(this.binaryMaxHeap.getSize() - 1, keyToInsert);
    }
    public int extractMax(){
        int max = this.maximum();
        binaryMaxHeap.replaceNodeAtIndexBy(0, binaryMaxHeap.getNodeAtIndex(binaryMaxHeap.getSize() - 1));
        binaryMaxHeap.decrementSize();
        binaryMaxHeap.maxHeapify(0);
        return max;
    }
    public void increaseKey(int nodeIndex, int key) throws InvalidKeyException {
        int nodeToIncreaseValue = binaryMaxHeap.getNodeAtIndex(nodeIndex);
        if(key < nodeToIncreaseValue)
            throw new InvalidKeyException(ExceptionsMessages.KEY_UNDER_CURRENT_VALUE + nodeToIncreaseValue + ", " + nodeIndex + ", " + key);
        binaryMaxHeap.replaceNodeAtIndexBy(nodeIndex, key);
        int parentIndex = binaryMaxHeap.parent(nodeIndex);
        nodeToIncreaseValue = binaryMaxHeap.getNodeAtIndex(nodeIndex);
        int parentNodeValue = binaryMaxHeap.getNodeAtIndex(parentIndex);
        int i = nodeIndex;
        while (i > 0 && parentNodeValue < nodeToIncreaseValue){
            parentNodeValue = binaryMaxHeap.getNodeAtIndex(binaryMaxHeap.parent(i));
            binaryMaxHeap.replaceNodeAtIndexBy(binaryMaxHeap.parent(i), nodeToIncreaseValue);
            binaryMaxHeap.replaceNodeAtIndexBy(i, parentNodeValue);
            i = binaryMaxHeap.parent(i);
        }
    }
    public int maximum(){
        if (binaryMaxHeap.getSize() < 1)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + 0);
        return binaryMaxHeap.getNodeAtIndex(0);
    }
    public int getSize(){
        return binaryMaxHeap.getSize();
    }
    public int getLength(){return binaryMaxHeap.getLength();}
    @Override
    public String toString() {
        return "MaxPriorityQueue{" +
                "binaryMaxHeap=" + binaryMaxHeap +
                '}';
    }
}
