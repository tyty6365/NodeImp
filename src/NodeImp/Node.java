package NodeImp;

        import java.util.Comparator;

public abstract class Node <K, V>{
    final Comparator c;
    final Object key;
    Object value;
    Node left, right;

    /**
     * Note that your subclass will need to call
     * this constructor using super().
     */
    public Node(K k, V v, Comparator<K> c) {
        key = k;
        value = v;
        this.c = c;
    }

    /**
     Transform the current node according
     to the diagram. Initially, the "this"
     variable should point to "t2". The
     return value should be a reconstructed
     tree with "t4" at the top.

     //    t2               t4
     //   /  \             /  \
     // t1    \    -->    /    t5
     //        t4       t2
     //       /  \     /  \
     //     t3    t5  t1   t3
     */
    public abstract Node rotateLeft();

    /**
     Transform the current node according
     to the diagram. Initially, the "this"
     variable should point to "t4". The
     return value should be a reconstructed
     tree with "t2" at the top.

     //       t4           t2
     //      /  \         /  \
     //     /    t5 --> t1    \
     //   t2                  t4
     //  /  \                /  \
     // t1   t3             t3   t5
     */
    public abstract Node rotateRight();

    /**
     * Compute the maximum number of
     * nodes that can be traversed
     * starting from this one (and
     * including this one).
     */
    public abstract int height();

    /**
     * Compute the total number of nodes
     * beneath (and including) this one.
     */
    public abstract int size();

    /**
     * (1) call the comparator and store the result in d.
     * (2) If d is zero, return the value on this node.
     * (3) If d is greater than zero, and if the right
     *     child is not null, then return the value from the
     *     right child.
     * (4) If d is less than zeero, and if the left
     *     child is not null, then return the value from the
     *     left child.
     * (5) If the above fails, return null.
     */
    public abstract V get(K key);

    /**
     * (1) call the comparator and store the result in d.
     * (2) If d is zero, update the value on this node
     *     with the value supplied in the argument.
     * (3a) If d is greater than zero, and if the right
     *     child is not null, then put the value into the
     *     right child.
     * (3b) If d is greater than zero, and if the right
     *     child is null, then create a new node and
     *     assign it to the right child.
     * (4a) If d is less than zeero, and if the left
     *     child is not null, then put the value into the
     *     left child.
     * (4b) If d is greater than zero, and if the left
     *     child is null, then create a new node and
     *     assign it to the left child.
     */
    public abstract void put(K key,V value);
}

