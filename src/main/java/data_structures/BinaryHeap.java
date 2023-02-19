package data_structures;


import utilitarian.ExceptionsMessages;

public class BinaryHeap {
    // Attribut indiquant le nombre d'élément actuel dans la structure où 0 est la racine.
    private int size = 0;
    private int[] array;

    public BinaryHeap(int[] arrayToConvertIntoHeap, boolean buildMinOrMaxHeap){
        this(arrayToConvertIntoHeap.length, buildMinOrMaxHeap);
        this.array = arrayToConvertIntoHeap;
        this.size = arrayToConvertIntoHeap.length;
    }
    public BinaryHeap(int heapSize, boolean minOrMaxHeap){
        this.array = new int[heapSize];
    }

    public int parent(int nodeIndexe){
        if(nodeIndexe < 0)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndexe);
        return this.array[nodeIndexe>>1];
    }
    public int leftChild(int nodeIndexe){
        if(nodeIndexe < 0)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndexe);
        nodeIndexe = (++nodeIndexe<<1) - 1;
        if(nodeIndexe > this.array.length)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndexe);
        return this.array[nodeIndexe];
    }
    public int rightChild(int nodeIndexe){
        if(nodeIndexe < 0)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndexe);
        nodeIndexe = (++nodeIndexe<<1);
        if(nodeIndexe > this.array.length)
            throw new ArrayIndexOutOfBoundsException(ExceptionsMessages.INDEX_NODE_OUT_OF_BOUND + nodeIndexe);
        return this.array[nodeIndexe];
    }
    public void maxHeapify(){

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
}
