package CS113;

import Interfaces.QueueInterface;

public class QueueRL<E> implements QueueInterface<E> {
    private class Node<E>{
        private E element;
        private Node<E> next;
        private Node<E> prev;
        private Node(E element){
            this.element = element;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int count;

    @Override
    public E push(E element) {
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
        return head.element;
        }

    @Override
    public E peek() {
        return head.element;
    }

    @Override
    public E pop() {
        Node<E> node = new Node<>(head.element);
        head = head.next;
        head.prev = null;
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
