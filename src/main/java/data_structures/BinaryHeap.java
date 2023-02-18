package data_structures;

public class BinaryHeap {
    // Attribut indiquant le nombre d'élément actuel dans la structure où 0 est la racine.
    public int size;
    private int[] array;

    public BinaryHeap(int heapSize){

    }

    public int parent(int nodeToRetrieveParent){
        return nodeToRetrieveParent>>1;
    }
    public int leftChild(int nodeToRetrieveChild){
        return 0;
    }
    public int rightChild(int nodeToRetrieveChild){
        return 0;
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
}
