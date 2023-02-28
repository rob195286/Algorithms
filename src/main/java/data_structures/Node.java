package data_structures;


public record Node(int index, int value) implements Comparable {
    @Override
    public int compareTo(Object o) {
        return ((Node)o).index;
    }
}
