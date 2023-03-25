package data_structures;

import java.util.Collection;
import java.util.Iterator;

public interface Holder extends Collection<Holder.Node> {

    record Node(int index, int value) {
    }
}
