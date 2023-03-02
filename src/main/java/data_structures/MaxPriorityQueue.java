package data_structures;

import utilitarian.ExceptionsMessages;

public class MaxPriorityQueue {
    private BinaryMaxHeap binaryMaxHeap;

    public MaxPriorityQueue(int[] arraytoConvertInMaxPriorityQueue){
        this.binaryMaxHeap = new BinaryMaxHeap(arraytoConvertInMaxPriorityQueue);
    }

    public void maxHeapInsert(int keyToInsert){

    }
    public int maxHeapExtractMax(){
        int max = this.maxHeapMaximum();
        int lastNodeIndex = this.binaryMaxHeap.getSize() - 1;
        this.binaryMaxHeap.replaceNodeAtIndexBy(0, this.binaryMaxHeap.getNodeAtIndex(lastNodeIndex));
        this.binaryMaxHeap.decrementSize();
        this.binaryMaxHeap.maxHeapify(0);
        return max;
    }
    public void maxHeapIncreaseKey(int key){

    }
    public int maxHeapMaximum(){
        if (this.binaryMaxHeap.getSize() < 1)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + 0);
        return this.binaryMaxHeap.getNodeAtIndex(0);
    }

    public int getSize(){
        return this.binaryMaxHeap.getSize();
    }
}
