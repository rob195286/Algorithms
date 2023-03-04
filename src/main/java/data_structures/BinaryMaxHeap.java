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
    public BinaryMaxHeap(int[] arrayToConvertIntoHeap, boolean convertArrayInHeap){
        this.array = arrayToConvertIntoHeap;
        this.size = arrayToConvertIntoHeap.length;
        if(convertArrayInHeap){
            this.buildMaxHeap();
        }
    }

    public int parent(int nodeIndex){
        if(nodeIndex <= 0)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndex);
        return (nodeIndex-1)>>1;
    }
    public int leftChild(int nodeIndex){
        if(nodeIndex < 0)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndex);
        nodeIndex = (++nodeIndex<<1) - 1;
        return nodeIndex;
    }
    public int rightChild(int nodeIndex){
        if(nodeIndex < 0)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndex);
        nodeIndex = (++nodeIndex<<1);
        return nodeIndex;
    }
    public void maxHeapify(int nodeIndex){
        int leftChildIndex = this.leftChild(nodeIndex), rightChildIndex = this.rightChild(nodeIndex);
        if(leftChildIndex > this.size || rightChildIndex > this.size)
            return;
        int nodeI = this.getNodeAtIndex(nodeIndex), largestIndex = nodeIndex;
        if(leftChildIndex < this.size && this.getNodeAtIndex(leftChildIndex) > nodeI)
            largestIndex = leftChildIndex;
        if(rightChildIndex < this.size && this.getNodeAtIndex(rightChildIndex) > this.getNodeAtIndex(largestIndex))
            largestIndex = rightChildIndex;
        // Echange l'emplacement du noeud le plus grand avec celui qui est le plus faible entre les enfants gauche/drotie.
        if(largestIndex != nodeIndex){
            this.replaceNodeAtIndexBy(nodeIndex, this.getNodeAtIndex(largestIndex));
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
    public void replaceNodeAtIndexBy(int nodeIndex, int newValue){
        this.array[nodeIndex] = newValue;
    }
    public void addKey(int key){
        this.array = Arrays.copyOf(this.array, this.array.length + 1);
        this.size++;
        this.array[this.array.length - 1] = key;
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
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.array, this.size));
    }
}

