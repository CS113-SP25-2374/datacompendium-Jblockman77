package CS113;

public class AVLBinarySearchTreeRL<E extends Comparable<E>> extends BinarySearchTreeRL<E>{

    public int isBalanced(Node<E> node){
        if(node == null){
            return 0;
        }
        return heightRecursive(node.left) - heightRecursive(node.right);
    }


    public Node<E> balance(Node<E> root){

        if(root==null){
            return null;
        }

        Node<E> tempNode = new Node<E>(root.element);
        if(isBalanced(root) < -1){
            root = root.right;
            insert(tempNode.element);
        }
        else if(isBalanced(root) > 1){
            root = root.left;
            insert(tempNode.element);
        }
        return balance(root);
    }
}