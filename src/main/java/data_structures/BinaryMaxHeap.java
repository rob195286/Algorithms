package data_structures;


import utilitarian.ExceptionsMessages;

public class BinaryMaxHeap {
    // Attribut indiquant le nombre d'élément actuel dans la structure où 0 est la racine.
    private int size = 0;
    private int[] array;

    public BinaryMaxHeap(int[] arrayToConvertIntoHeap, boolean buildMinOrMaxHeap){
        this(arrayToConvertIntoHeap.length, buildMinOrMaxHeap);
        this.array = arrayToConvertIntoHeap;
        this.size = arrayToConvertIntoHeap.length;
    }
    public BinaryMaxHeap(int heapSize, boolean minOrMaxHeap){
        this.array = new int[heapSize];
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
        if(nodeIndex > this.getLength())
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndex);
        return nodeIndex;
    }
    public int rightChild(int nodeIndex){
        if(nodeIndex < 0)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndex);
        nodeIndex = (++nodeIndex<<1);
        if(nodeIndex > this.getLength())
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndex);
        return nodeIndex;
    }
    public void maxHeapify(int nodeIndex){
        int leftChild = this.leftChild(nodeIndex);
        int rightChild = this.rightChild(nodeIndex);
        int largest = this.getNodeAtIndex(nodeIndex);
        if(leftChild <= this.getSize() && leftChild > largest)
            largest = leftChild;
        if(rightChild <= this.getSize() && rightChild > largest)
            largest = rightChild;
        if(largest != this.getNodeAtIndex(nodeIndex)){ // Echange d'emplacement le noeud le plus grand avec son parent.
            this.setNodeAtIndex(this.getNodeAtIndex(nodeIndex), largest);
            if(largest == leftChild)
                this.setNodeAtIndex(this.getNodeAtIndex(this.leftChild(nodeIndex)), largest);
            if(largest == rightChild)
                this.setNodeAtIndex(this.getNodeAtIndex(this.rightChild(nodeIndex)), largest);
        }
    }
    public void buildMaxHeap(){

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
    public int getSize(){
        return this.size;
    }
    public int getLength(){
        return this.array.length;
    }
    private int getNodeAtIndex(int nodeIndex){
        return this.array[nodeIndex];
    }
    private void setNodeAtIndex(int nodeIndex, int newValue){
        this.array[nodeIndex] = newValue;
    }
}
