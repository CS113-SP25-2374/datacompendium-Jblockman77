package CS113;

public class StackRL<E> implements StackInterface<E>{
    private class Node<E>{
        private E element;
        private Node<E> next;
        private Node<E> prev;
        private Node(E element){
            this.element = element;
        }
    }
    private Node<E> tail;
    private int count;

    @Override
    public E push(E element) {
        Node<E> node = new Node<>(element);
        if (tail != null) {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        count++;
        return tail.element;
    }

    @Override
    public E peek() {
        return tail.element;
    }

    @Override
    public E pop() {
        Node<E> node = new Node<>(tail.element);
        tail = tail.prev;
        count--;
        return node.element;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
    public String toString(){
        StringBuilder sen = new StringBuilder();
        sen.append("]");
        Node<E> curr = tail;
        while (curr != null){
            sen.append(curr.element);
            if(curr.prev != null){
                sen.append(", ");
            }
            curr = curr.prev;
        }
        sen.append("[");
        sen.reverse();
        return sen.toString();
    }
}
