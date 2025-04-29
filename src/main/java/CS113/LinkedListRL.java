package CS113;

import Interfaces.DequeInterface;
import Interfaces.ListInterface;
import Interfaces.ListIterableInterface;
import Interfaces.ListIteratorInterface;

public class LinkedListRL<E> implements ListInterface<E>, ListIterableInterface<E>, DequeInterface<E> {

    private class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        private Node(E element) { this.element = element; }
    }

    private class Iterator<E> implements ListIteratorInterface<E> {
        private Node<E> current;
        LinkedListRL<E> list;
        int index = 0;

        private Iterator(LinkedListRL<E> list) {
            this.list = list;
        }

        @Override
        public void add(E element) {
            Node<E> node = new Node<>(element);
            list.linkNode((LinkedListRL<E>.Node<E>) node, (LinkedListRL<E>.Node<E>) current);
        }

        @Override
        public boolean hasNext() {
            if (current == null) return list.head != null;
            return current.next != null;
        }

        @Override
        public boolean hasPrevious() {
            if (current == null) return list.tail != null;
            return current.prev != null;
        }

        @Override
        public E next() {
            if (current == null) current = (Node<E>) list.head;
            else {
                current = current.next;
                index++;
            }
            return current.element;
        }

        @Override
        public E previous() {
            if (current == null) current = (Node<E>) list.tail;
            else {
                current = current.prev;
                index--;
            }
            return current.element;
        }

        @Override
        public void remove() {
            Node<E> curr = current.next;
            list.unlinkNode((LinkedListRL<E>.Node<E>) current);
            current = curr;
        }

        @Override
        public void set(E element) {
            current.element = element;
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private final Iterator<E> iterator = new Iterator<>(this);

    private Node<E> iterateTo(E element) {
        Node<E> curr = head;
        while (curr != null) {
            if (curr.element.equals(element)) return curr;
            curr = curr.next;
        }
        return null;
    }

    private Node<E> iterateTo(int index) {
        int i = 0;
        Node<E> curr = head;
        while (curr != null) {
            if (i == index) return curr;
            i++;
            curr = curr.next;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<E> curr = head;
        while (curr != null) {
            if (curr.element.equals(o)) return index;
            index++;
            curr = curr.next;
        }
        return -1;
    }

    private void unlinkNode(Node<E> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (head == node) {
            head = node.next;
        }

        if (tail == node) {
            tail = node.prev;
        }

        size--;
    }

    private void linkPrev(Node<E> node, Node<E> curr) {
        if (curr != null && curr.prev != null) {
            linkNode(node, curr.prev);
        } else { // head of the list
            node.next = head;
            node.prev = null;
            head = node;
            if (node.next != null) node.next.prev = node;
            size++;
        }
    }

    private void linkNode(Node<E> node, Node<E> curr) {
        if (curr == null) {
            head = tail = node;
        } else {
            node.next = curr.next;
            node.prev = curr;
            curr.next = node;
            if (node.next != null) {
                node.next.prev = node;
            }
            if (tail == curr) {
                tail = node;
            }
        }

        size++;
    }

    @Override
    public boolean add(E element) {
        Node<E> node = new Node<>(element);

        if (head == null) {
            linkNode(node, tail);
            head = node;
        } else {
            linkNode(node, tail);
        }

        return true;
    }

    @Override
    public void add(int index, E element) {
        Node<E> node = new Node<>(element);
        Node<E> curr = iterateTo(index-1);
        linkNode(node, curr);
    }

    @Override
    public void clear() {
        while (head != null) {
            unlinkNode(head);
        }
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public E get(int index) {
        Node<E> node = iterateTo(index);
        return node != null ? node.element : null;
    }

    @Override
    public boolean offerFirst(E element) {
        addFirst(element);
        return true;
    }

    @Override
    public boolean offerLast(E element) {
        addLast(element);
        return true;
    }

    @Override
    public boolean addFirst(E element) {
        Node<E> node = new Node<>(element);
        linkPrev(node, head);
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Node<E> node = new Node<>(element);
        linkNode(node, tail);
        return true;
    }

    @Override
    public E removeFirst() {
        return pollFirst();
    }

    @Override
    public E removeLast() {
        return pollLast();
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
        Node<E> curr = head;
        unlinkNode(curr);
        return curr.element;
    }

    @Override
    public E pollLast() {
        Node<E> curr = tail;
        unlinkNode(curr);
        return curr.element;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean remove(int index) {
        Node<E> node = iterateTo(index);
        if (node != null) unlinkNode(node);
        return true;
    }

    @Override
    public boolean remove(E element) {
        Node<E> node = iterateTo(element);
        if (node != null) unlinkNode(node);
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, E element) {
        Node<E> node = iterateTo(index);
        if (node != null) node.element = element;
    }

    @Override
    public ListIteratorInterface<E> iterator() {
        iterator.current = null;
        return iterator;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> node = head;
        while (node != null) {
            sb.append(node.element);
            if (node.next != null) {
                sb.append(", ");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}