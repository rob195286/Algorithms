package data_structures;

import java.util.Iterator;

public class ArrayHolder extends Holder {
    private Node[] nodes;
    private int arraySize = 0;

    public ArrayHolder(int[] arrayToConvert) {
        nodes = new Node[arrayToConvert.length];
        int index = 0;
        for(int value : arrayToConvert){
            nodes[index] = new Node(++index, value);
        }
        arraySize = index;
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<>() {
            int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < arraySize;
            }
            @Override
            public Node next() {
                return nodes[++currentIndex];
            }
        };
    }

    @Override
    public int size() {
        return arraySize;
    }

    @Override
    public Node getNextNode(int currentNodeIndex) {
        // todo : check si on sort de la limite
        return nodes[++currentNodeIndex];
    }

    @Override
    public Node getNodeByIndex(int currentNodeIndex) {
        return nodes[currentNodeIndex];
    }

    @Override
    public void exchangeNodes(Node n1, Node n2) {
        Node tmpNode = nodes[n1.index() - 1];
        nodes[n1.index() - 1] = n2;
        nodes[n2.index() - 1] = tmpNode;
    }
}
