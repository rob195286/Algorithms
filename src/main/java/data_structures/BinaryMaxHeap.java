package data_structures;


import util.ExceptionsMessages;

import java.util.Arrays;

public class BinaryMaxHeap {
    // Attribut indiquant le nombre d'élément actuel dans la structure où 0 est la racine.
    private int size;
    private int[] array;
    // todo : voir si possibilité faire un minheap
    public BinaryMaxHeap(int[] arrayToConvertIntoHeap){
        array = arrayToConvertIntoHeap;
        size = arrayToConvertIntoHeap.length;
        buildMaxHeap();
    }

    public int parent(int nodeIndex){
        if(nodeIndex <= 0)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndex);
        return (nodeIndex - 1) >> 1;
    }
    public int leftChild(int nodeIndex){
        if(nodeIndex < 0)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndex);
        nodeIndex = (++nodeIndex << 1) - 1;
        return nodeIndex;
    }
    public int rightChild(int nodeIndex){
        if(nodeIndex < 0)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndex);
        nodeIndex = (++nodeIndex << 1);
        return nodeIndex;
    }
    public void maxHeapify(int nodeIndex){
        int leftChildIndex = leftChild(nodeIndex), rightChildIndex = rightChild(nodeIndex);
        if(leftChildIndex > this.size || rightChildIndex > this.size)
            return;
        int nodeI = getNodeAtIndex(nodeIndex), largestIndex = nodeIndex;
        if(leftChildIndex < this.size && getNodeAtIndex(leftChildIndex) > nodeI)
            largestIndex = leftChildIndex;
        if(rightChildIndex < this.size && getNodeAtIndex(rightChildIndex) > getNodeAtIndex(largestIndex))
            largestIndex = rightChildIndex;
        // Echange l'emplacement du noeud le plus grand avec celui qui est le plus faible entre les enfants gauche/drotie.
        if(largestIndex != nodeIndex){
            replaceNodeAtIndexBy(nodeIndex, getNodeAtIndex(largestIndex));
            if(largestIndex == leftChildIndex)
                replaceNodeAtIndexBy(leftChildIndex, nodeI);
            else
                replaceNodeAtIndexBy(rightChildIndex, nodeI);
            maxHeapify(largestIndex);
        }
    }
    public int getNodeAtIndex(int nodeIndex){
        return array[nodeIndex];
    }
    public int getSize(){
        return size;
    }
    public int getLength(){
        return array.length;
    }
    // todo : voir si pas mieux de rendre priver et de gérer ça en interne
    public void decrementSize(){
        size--;
    }
    public void replaceNodeAtIndexBy(int nodeIndex, int newValue){
        this.array[nodeIndex] = newValue;
    }
    public void addKey(int key){
        if(this.array.length == this.size){
            this.array = Arrays.copyOf(this.array, this.array.length + 1);
        }
        this.array[this.size] = key;
        this.size++;
    }
    @Override
    public boolean equals(Object o){
        if(o == null)
            return false;
        if (o == this)
            return true;
        return o instanceof BinaryMaxHeap &&
               Arrays.compare(this.array, ((BinaryMaxHeap)o).array) == 0;
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.array, this.size));
    }
    private void buildMaxHeap(){
        for (int i = (this.size - 1)/2; i >= 0; i--){
            maxHeapify(i);
        }
    }
}

