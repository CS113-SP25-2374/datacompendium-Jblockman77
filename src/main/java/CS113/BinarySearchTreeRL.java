package CS113;

public class BinarySearchTreeRL<E extends Comparable<E>> implements BinarySearchTree<E>{
    private class Node<E>{
        private E element;
        private Node<E> right;
        private Node<E> left;
        private Node<E> root;
        private Node(E element){
            this.element = element;
        }
    }

    private int count;
    private Node<E> rootNode;

    Node<E> insertRecursive(Node<E> node, E value){
        if(node == null){
            return new Node<E>(value);
        }
        if(node.element.compareTo(value) > 0){
            node.left = insertRecursive(node.left, value);
        }
        if(node.element.compareTo(value) < 0){
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    public E inOrderRecursive(Node<E> node, E value){
        if(node == null){
            return null;
        }
        if(node.left != null){
            inOrderRecursive(node.left, node.element);
            }
        if(node.right != null){
            inOrderRecursive(node.right, node.element);
        }
        if(node.left == null && node.right == null){
            return node.element;
        }
        return value;
    }

    @Override
    public void insert(E value) {
        rootNode = insertRecursive(rootNode, value);
        }

    public Node<E> deleteRecursive(Node<E> node, E value) {
        if (node == null) {
            return null;
        }
        if (node.element == value) {
            Node<E> replace = null;
            if (heightRecursive(node) == 1) {
                return null;
            }
            if (heightRecursive(node.right) > heightRecursive(node.left)) {
                replace = findMinRecursive(node.right);
            } else {
                replace = findMaxRecursive(node.left);
            }
            deleteRecursive(node, replace.element);
            replace.left = node.left;
            replace.right = node.right;
            return replace;
        }
    }

    @Override
    public boolean delete(E value) {
        rootNode = deleteRecursive(rootNode, value);
        return true;
    }

    private boolean containCheck;

    public Node<E> containsRecursive(Node<E> node, E value){
        if(node == null){
            return null;
        }
        if(node.element.compareTo(value) > 0){
            node.left = containsRecursive(node.left, value);
        }
        if(node.element.compareTo(value) < 0){
            node.right = containsRecursive(node.right, value);
        }
        if(node.element.compareTo(value) == 0){
            containCheck = true;
            return null;
        }
        return node;
    }
    @Override
    public boolean contains(E value) {
        containsRecursive(rootNode, value);
        return containCheck;
    }

    public Node<E> findMinRecursive(Node<E> node){
        if(node.left == null){
            return node;
        }
        return findMinRecursive(node.left);
    }

    @Override
    public E findMin() {
        return findMinRecursive(rootNode).element;
    }

    public Node<E> findMaxRecursive(Node<E> node){
        if(node.right == null)
            return node;
        return findMaxRecursive(node.right);
    }

    @Override
    public E findMax() {

        return findMaxRecursive(rootNode).element;
    }

    public int heightRecursive(Node<E> node){
        if(node == null){
            return 0;
        }
        return 1 + Integer.max(heightRecursive(node.left),heightRecursive(node.right));
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    public void clearRecursive(Node<E> node){
        if(node == null) return;

        clearRecursive(node.left);
        clearRecursive(node.right);
        node.left = null;
        node.right = null;
    }

    @Override
    public void clear() {
        rootNode = null; // modern day solution!

    }
    public String recurseToString(Node<E> node){
        if(node == null) {
            return "";
        }
        String left = recurseToString(node.left);
        String center = node.element.toString();
        String right = recurseToString(node.right);
        return recurseToString(node.left) + node.element.toString() + recurseToString(node.right);
    }

    @Override
    public String toString(){
        return recurseToString(rootNode);
    }
}
