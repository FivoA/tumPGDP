public class Tree_Implementation {
    // An example tree implementation with functions!


    // a tree node class
    import java.util.List;

    public abstract class Node<T> {

        private T value;
        private Node<T>[] children;

        @SafeVarargs
        public Node(T value, Node<T>... nodes) {
            this.value = value;
            children = nodes;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        // you will need this method for a bonus-exercise in week 10
        //	public Node<T>[] getChildren() {
        //		return children;
        //	}

        public Node<T> getChild(int i) {
            if (i < 0 || children.length <= i) {
                return null;
            }
            return children[i];
        }

        public void setChild(int i, Node<T> c) {
            if (i < 0 || children.length <= i) {
                return;
            }
            children[i] = c;
        }

        public boolean isLeaf() {
            for (Node<T> node : children) {
                if (node != null) {
                    return false;
                }
            }
            return true;
        }

        public int height() {
            int height = 0;
            for (Node<T> node : children) {
                if (node != null) {
                    int nodeHeight = node.height();
                    height = height < nodeHeight ? nodeHeight : height;
                }
            }
            return height + 1;
        }

        public int size() {
            int size = 0;
            for (Node<T> node : children) {
                if (node != null) {
                    size += node.size();
                }
            }
            return size + 1;
        }

        public abstract List<T> toList(Order order);



    //BST Implementation
    import java.util.LinkedList;
    import java.util.List;

    public class BST<T extends Comparable<T>> {

        private BSTNode<T> root;

        public BST() {
            root = null;
        }

        public boolean isEmpty() {
            return root == null;
        }

        public int size() {
            if (root == null) {
                return 0;
            }
            return root.size();
        }

        public boolean contains(T value) {
            if (isEmpty()) {
                return false;
            }
            return root.contains(value);
        }

        public void insert(T value) {
            if (value == null) {
                return;
            }
            if (isEmpty()) {
                root = new BSTNode<T>(value);
            } else {
                root.insert(value);
            }
        }

        public List<T> toList() {
            if (isEmpty()) {
                return new LinkedList<>();
            }
            return root.toList(Order.IN);
        }

        @Override
        public String toString() {
            if (isEmpty()) {
                return "[]";
            } else {
                return root.toString();
            }
        }
    }

    public class BSTNode<T extends Comparable<T>> extends BinaryNode<T> {

        public BSTNode(T value, BSTNode<T> left, BSTNode<T> right) {
            super(value, left, right);
        }

        public BSTNode(T value) {
            super(value, null, null);
        }

        public boolean contains(T value) {
            if (getValue().equals(value)) {
                return true;
            } else if (value.compareTo(getValue()) < 0) {
                if (getLeft() == null) {
                    return false;
                } else {
                    return ((BSTNode<T>) getLeft()).contains(value);
                }
            } else {
                if (getRight() == null) {
                    return false;
                } else {
                    return ((BSTNode<T>) getRight()).contains(value);
                }
            }
        }

        public void insert(T value) {
            if (getValue().equals(value)) {
                return;
            } else if (value.compareTo(getValue()) < 0) {
                if (getLeft() == null) {
                    setLeft(new BSTNode<T>(value));
                } else {
                    ((BSTNode<T>) getLeft()).insert(value);
                }
            } else {
                if (getRight() == null) {
                    setRight(new BSTNode<T>(value));
                } else {
                    ((BSTNode<T>) getRight()).insert(value);
                }
            }
        }

    }

}
