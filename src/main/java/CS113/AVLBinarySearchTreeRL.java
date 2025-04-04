package CS113;

public class AVLBinarySearchTreeRL<E extends Comparable<E>> extends BinarySearchTreeRL<E>{

    public int isBalanced(Node<E> node){
        if(node == null){
            return 0;
        }
        return heightRecursive(node.left) - heightRecursive(node.right);
    }

    Node<E> rotateLeft(Node<E> node){
        Node<E> rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        return rightChild;
    }

    Node<E> rotateRight(Node<E> node){
        Node<E> leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        return leftChild;
    }


    public Node<E> balance(Node<E> root){

        if(root==null){
            return null;
        }

        int theBalance = isBalanced(root);

        if(theBalance > 1){
            if(isBalanced(root.right) < 0) {
                root.right = rotateRight(root.right);
            }
            root = rotateLeft(root);
        }
        if(theBalance < -1){
            if(isBalanced(root.left) > 0) {
                root.left = rotateLeft(root.left);
            }
            root = rotateRight(root);
        }
        return root;
    }

    @Override
    Node<E> insertRecursive(Node<E> node, E element){
        node = super.insertRecursive(node, element);
        node = balance(node);
        return node;
    }

    @Override
    public Node<E> deleteRecursive(Node<E> node, E element) {
        node = super.deleteRecursive(node, element);
        node = balance(node);
        return node;
    }

}