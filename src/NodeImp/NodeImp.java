package NodeImp;

import java.util.Comparator;

public class NodeImp <K, V> extends Node<K, V> {

    public NodeImp(K k, V v, Comparator<K> c)  {
        super(k, v, c);
    }

    public Node rotateLeft() {
        NodeImp<K, V> t2 = this;
        Node t4 = t2.right;
        t2.right = t4.left;
        t4.left = t2;

        return t4; //what we are returning is what goes on top of the reconstructed tree
    }

    public Node rotateRight() {

        NodeImp<K, V> t4 = this;
        Node t2 = t4.left;
        t4.left = t2.right;
        t2.right = t4;


        return t2;
    }

    public int height() {
        int hr = 0;
        int h1 = 0;
        if (right != null) {
            hr = right.height();
        }
        if (left != null) {
            h1 = left.height();
        }
        if (hr > h1) {
            return 1 + hr;
        } else {
            return h1 + 1;
        }
    }

    public int size() {
        int ts = 0;
        int al = 0;
        if (left != null) {
            ts = left.size();
        }
        if (right != null) {
            al = right.size();
        }
        return 1 + ts + al;
    }



    @Override
    public V get(K key) {
        int d = c.compare(key, this.key);
        if (d == 0) {
            return (V)this.value;
        }
        if (d > 0 && right != null) {
            return (V)right.get(key);
        }
        if (d < 0 && left != null) {
            return (V)left.get(key);
        }else {
            return null;
        }
    }

    @Override
    public void put(K key, V value) {
        int d = c.compare(key, this.key);
        if (d == 0) {
            this.value = value;
        } else if (d > 0)
            if (right != null) {
                right.put(key, value);
            } else {
                right = new NodeImp(key, value, c);
            }
        else if (d < 0) {
            if (left != null) {
                left.put(key, value);
            } else {
                left = new NodeImp(key, value, c);
            }
        }
    }

}
