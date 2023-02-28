package data_structures;


import utilitarian.ExceptionsMessages;

import java.util.Arrays;

public class BinaryMaxHeap {
    // Attribut indiquant le nombre d'élément actuel dans la structure où 0 est la racine.
    private int size;
    private int[] array;

    public BinaryMaxHeap(int[] arrayToConvertIntoHeap){
        this(arrayToConvertIntoHeap, true);
    }
    public BinaryMaxHeap(int[] arrayToConvertIntoHeap, boolean buildArrayInHeap){
        this.array = arrayToConvertIntoHeap;
        this.size = arrayToConvertIntoHeap.length;
        if(buildArrayInHeap){
            this.buildMaxHeap();
        }
    }

    public int parent(int i){
        if(i <= 0)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + i);
        return (i-1)>>1;
    }
    public int leftChild(int i){
        if(i < 0)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + i);
        i = (++i<<1) - 1;
        return i;
    }
    public int rightChild(int i){
        if(i < 0)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + i);
        i = (++i<<1);
        return i;
    }
    public void maxHeapify(int index){
        int leftChildIndex = this.leftChild(index), rightChildIndex = this.rightChild(index);
        if(leftChildIndex > this.size || rightChildIndex > this.size)
            return;
        int nodeI = this.getNodeAtIndex(index), largestIndex = index;
        if(leftChildIndex < this.size && this.getNodeAtIndex(leftChildIndex) > nodeI)
            largestIndex = leftChildIndex;
        if(rightChildIndex < this.size && this.getNodeAtIndex(rightChildIndex) > this.getNodeAtIndex(largestIndex))
            largestIndex = rightChildIndex;
        // Echange l'emplacement du noeud le plus grand avec celui qui est le plus faible entre les enfants gauche/drotie.
        if(largestIndex != index){
            this.replaceNodeAtIndexBy(index, this.getNodeAtIndex(largestIndex));
            if(largestIndex == leftChildIndex)
                this.replaceNodeAtIndexBy(leftChildIndex, nodeI);
            else
                this.replaceNodeAtIndexBy(rightChildIndex, nodeI);
            this.maxHeapify(largestIndex);
        }
    }
    public void buildMaxHeap(){
        for (int i = (this.size-1)/2; i >= 0; i--){
            this.maxHeapify(i);
        }
    }
    public void maxHeapInsert(int keyToInsert){

    }
    public int maxHeapExtractMax(){
        return 0;
    }
    public void maxHeapIncreaseKey(int key){

    }
    public void maxHeapMaximum(){

    }
    public int getNodeAtIndex(int nodeIndex){
        return this.array[nodeIndex];
    }
    public int getSize(){
        return this.size;
    }
    public int getLength(){
        return this.array.length;
    }
    public void decrementSize(){
        this.size--;
    }
    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if (o == this){
            return true;
        }
        if (!(o instanceof BinaryMaxHeap)){
            return false;
        }
        return Arrays.compare(this.array, ((BinaryMaxHeap)o).array) == 0;
    }
    public void replaceNodeAtIndexBy(int nodeIndex, int newValue){
        this.array[nodeIndex] = newValue;
    }
}
