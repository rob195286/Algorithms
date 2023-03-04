package data_structures;

import utilitarian.ExceptionsMessages;
import java.security.InvalidKeyException;


public class MaxPriorityQueue {
    private final BinaryMaxHeap binaryMaxHeap;

    public MaxPriorityQueue(int[] arraytoConvertInMaxPriorityQueue){
        this.binaryMaxHeap = new BinaryMaxHeap(arraytoConvertInMaxPriorityQueue);
    }

    public void maxHeapInsert(int keyToInsert) throws InvalidKeyException {
        this.binaryMaxHeap.addKey(keyToInsert);
        this.maxHeapIncreaseKey(this.binaryMaxHeap.getSize() - 1, keyToInsert);
    }
    public int maxHeapExtractMax(){
        int max = this.maxHeapMaximum();
        int lastNodeIndex = this.binaryMaxHeap.getSize() - 1;
        this.binaryMaxHeap.replaceNodeAtIndexBy(0, this.binaryMaxHeap.getNodeAtIndex(lastNodeIndex));
        this.binaryMaxHeap.decrementSize();
        this.binaryMaxHeap.maxHeapify(0);
        return max;
    }
    public void maxHeapIncreaseKey(int nodeIndex, int key) throws InvalidKeyException {
        int nodeToIncreaseValue = this.binaryMaxHeap.getNodeAtIndex(nodeIndex);
        if(key < nodeToIncreaseValue)
            throw new InvalidKeyException(ExceptionsMessages.KEY_UNDER_CURRENT_VALUE + nodeToIncreaseValue + ", " + nodeIndex + ", " + key);
        this.binaryMaxHeap.replaceNodeAtIndexBy(nodeIndex, key);
        int parentIndex = this.binaryMaxHeap.parent(nodeIndex);
        nodeToIncreaseValue = this.binaryMaxHeap.getNodeAtIndex(nodeIndex);
        int parentNodeValue = this.binaryMaxHeap.getNodeAtIndex(parentIndex);
        int i = nodeIndex;
        while (i > 0 && parentNodeValue < nodeToIncreaseValue){
            parentNodeValue = this.binaryMaxHeap.getNodeAtIndex(this.binaryMaxHeap.parent(i));
            this.binaryMaxHeap.replaceNodeAtIndexBy(this.binaryMaxHeap.parent(i), nodeToIncreaseValue);
            this.binaryMaxHeap.replaceNodeAtIndexBy(i, parentNodeValue);
            i = this.binaryMaxHeap.parent(i);
        }
    }
    public int maxHeapMaximum(){
        if (this.binaryMaxHeap.getSize() < 1)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + 0);
        return this.binaryMaxHeap.getNodeAtIndex(0);
    }

    public int getSize(){
        return this.binaryMaxHeap.getSize();
    }

    @Override
    public String toString() {
        return "MaxPriorityQueue{" +
                "binaryMaxHeap=" + this.binaryMaxHeap +
                '}';
    }
}
