package CS113;

public class DequeRL<E> implements DequeInterface<E>{
    private class Node<E>{
        private E element;
        private Node<E> next;
        private Node<E> prev;
        private Node(E element){
            this.element = element;
        }
    }

    private int count;
    private Node<E> tail;
    private Node<E> head;

    @Override
    public boolean offerFirst(E element) {
        return false;
    }

    @Override
    public boolean offerLast(E element) {
        return false;
    }

    @Override
    public boolean addFirst(E element) {
        Node<E> node = new Node<>(element);
        if(head == null){
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        count++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Node<E> node = new Node<>(element);
        if (tail != null) {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        count++;
        return true;
    }

    @Override
    public E removeFirst() {
        Node<E> node = new Node<>(head.element);
        head = head.next;
        head.prev = null;
        count--;
        return node.element;
    }

    @Override
    public E removeLast() {
        Node<E> node = new Node<>(tail.element);
        tail = tail.prev;
        count--;
        return node.element;
    }

    @Override
    public E peekFirst() {
        return head.element;
    }

    @Override
    public E peekLast() {
        return tail.element;
    }

    @Override
    public E pollFirst() {
        Node<E> node = new Node<>(head.element);
        head = head.next;
        head.prev = tail.next;
        count--;
        return node.element;
    }

    @Override
    public E pollLast() {
        Node<E> node = new Node<>(tail.element);
        tail = tail.prev;
        tail.next = head.prev;
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
        sen.append("[");
        Node<E> curr = head;
        while (curr != null){
            sen.append(curr.element);
            if(curr.next != null){
                sen.append(", ");
            }
            curr = curr.next;
        }
        sen.append("]");
        return sen.toString();
    }
}
