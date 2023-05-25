package data_structures;

import java.util.AbstractCollection;
import java.util.Iterator;


public abstract class Holder extends AbstractCollection<Holder.Node> {
    @Override
    public abstract Iterator<Node> iterator();
    @Override
    public abstract int size();
    record Node<T>(int index, T value) {}
    public abstract Node getNextNode(int currentNodeIndex);
    public abstract Node getNodeByIndex(int currentNodeIndex);
    public abstract void exchangeNodes(Node n1, Node n2);
}
