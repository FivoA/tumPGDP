/*  import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Iterators {
    // There will be many iterators here for all types of collections!


    //ITERATOR FOR HARD PGDP AUFGABE QUATERNY SEARCH TREE
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            LinkedList<NodeIdxPair<T>> stack = new LinkedList<>(List.of(new NodeIdxPair<>(root)));
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Trying to call next on an empty QuarternarySearchTreeIterator");
                }
                NodeIdxPair<T> current = stack.peek();
                while (true) {
                    if (current.idx % 2 == 1) {
                        // id is ungerade, so we have an element to return
                        current.idx+=1;
                        NodeIdxPair<T> ret = current;
                        while (current != null && // reached last value?
                                (current.idx > 6 // full node completed?
                                        || current.idx > 2 * current.node.getNodeSize() + 1 // partly filled node completed?
                                        || current.idx == 2 * current.node.getNodeSize() // node with empty right-most child completed?
                                        && current.node.getChild(current.idx / 2) == null)){
                            //move up
                            stack.pop();
                            current = stack.peek();
                        }
                        return ret.node.getValue((ret.idx-1)/2);
                    } else {
                        // we have to further explore
                        if (current.node.getChild(current.idx/2)==null) {
                            //no children, we inc idx and go back
                            current.idx+=1;
                            continue;
                        }
                        //move down
                        stack.peek().idx++;
                        stack.push(new NodeIdxPair<>(current.node.getChild(current.idx/2)));
                        current = stack.peek();
                    }
                }
            }

            @Override
            public boolean hasNext() {
                return root!=null && !stack.isEmpty();
            }
        };
    }
    private static class NodeIdxPair<T extends Comparable<T>> {
        public QuarternaryNode<T> node;
        public int idx;

        public NodeIdxPair(QuarternaryNode<T> node) {
            this.node = node;
            idx = 0;
        }
        @Override
        public String toString() {
            return "Node: " + node.toString() + " - Size: " + node.getNodeSize() + "\t idx: " + idx;
        }
    }
    //end

    // A LIST ITERATOR
    public java.util.Iterator<T> iterator() {
        public class Iterator implements java.util.Iterator<T> {
            private Element element;

            public Iterator(Element e) {
                element = e;
            }

            @Override
            public boolean hasNext() {
                return element != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                var v = element.value;
                element = element.next;
                return v;
            }
        }
    }
    //end

    // A 2D LIST ITERATOR
    public Iterator<T> iterator() {
        return new List2DIterator(lists);
    }

    public class List2DIterator implements Iterator<T> {
        private Iterator<List<T>> listIterator;
        private Iterator<T> currentIterator;


        public List2DIterator(List<List<T>> lists) {
            listIterator = lists.iterator();
            while (listIterator.hasNext()) {
                currentIterator = listIterator.next().iterator();
                if (currentIterator.hasNext()) {
                    break;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return currentIterator != null && currentIterator.hasNext();
        }

        @Override
        public T next() {
            T current = currentIterator.next();
            while (!currentIterator.hasNext() && listIterator.hasNext()) {
                currentIterator = listIterator.next().iterator();
            }
            return current;
        }
    }
    // end

    // A BST TREE ITERATOR
    public class Iterator implements java.util.Iterator<T> {

        private Iterator left = null;
        private Iterator right = null;
        private boolean yieldedOwnValue = false;
        private final Element element;

        public Iterator(Element e) {
            element = e;
            if (e != null) {
                left = new Iterator(e.left);
                right = new Iterator(e.right);
            }
        }

        @Override
        public boolean hasNext() {
            if (element == null) {
                return false;
            }
            return left.hasNext() || !yieldedOwnValue || right.hasNext();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (left.hasNext()) {
                return left.next();
            }
            else if (!yieldedOwnValue) {
                yieldedOwnValue = true;
                return element.value;
            }
            else {
                return right.next();
            }
        }
    }
    // end

    // ANOTHER BST TREE ITERATOR WITH STACK
    class BSTIterator {

        TreeNode temp;
        Stack<TreeNode> stk = new Stack<>();

        public BSTIterator(TreeNode root) {
            this.temp = root;
        }

        public int next() {
            int t = 0;
            while (true){
                if (temp!=null){
                    stk.push(temp);
                    temp = temp.left;
                }
                else if(temp==null && stk.isEmpty()){
                    break;
                }
                else{
                    temp = stk.isEmpty() ? null : stk.pop();
                    if(temp!=null) t = temp.val;
                    temp = temp.right;
                    break;
                }
            }
            return t;
        }

        public boolean hasNext() {
            return temp!=null || (temp==null && !stk.isEmpty());
        }

    }
    //end


    // A TRAVEL ITERATORS MAYBE FOR GRAPHS
    public class TravelIterator implements Iterator<Destination> {

    public List<Destination> alreadyVisited;
    private Destination currentDestination;

    // Do not change the signature of the constructor!
    public TravelIterator(Destination startDestination) {
        currentDestination = startDestination;
        alreadyVisited= new ArrayList<>();
    }

    @Override
    public boolean hasNext() {
        return currentDestination!=null;
    }

    @Override
    public Destination next() {
        Destination tmp = currentDestination;
        alreadyVisited.add(currentDestination);
        boolean hasFound = false;
        for (Destination d: currentDestination.getTrainConnections()) {
            if (!alreadyVisited.contains(d)){
                currentDestination = d;
                hasFound=true;
                break;
            }
        }
        if (!hasFound){
            currentDestination = null;
        }
        return tmp;
    }
    }
    //end



}



 */