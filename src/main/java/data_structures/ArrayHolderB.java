package data_structures;


//public class ArrayHolder implements Container {
    /*
    private Node[] arrayHolder;
    private int arraySize = 0;

    public ArrayHolder(int[] arrayToConvert) {
        arrayHolder = new Node[arrayToConvert.length];
        int index = 1;
        for(int value : arrayToConvert){
            arrayHolder[index] = new Node(index++, value);
        }
    }

    @Override
    public int size() {
        return arraySize;
    }

    @Override
    public boolean isEmpty() {
        return arraySize == 0;
    }

    @Override
    public boolean contains(Object o) {
        if(o.getClass() != Node.class){
            // todo : gérer exception
            return false;
        }
        return ((Node) o).index() < size();
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            @Override
            public boolean hasNext() {
                return currentIndex < arraySize;
            }

            @Override
            public Node next() {
                return arrayHolder[++currentIndex];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return arrayHolder;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Node node) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Node> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Node getNextNode(int currentNodeIndex) {
        return null;
    }

    @Override
    public void exchangeNodes(Node n1, Node n2) {

    }
}
     */