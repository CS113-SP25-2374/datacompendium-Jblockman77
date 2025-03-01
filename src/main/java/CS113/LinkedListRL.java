package CS113;

public class LinkedListRL<E> implements ListInterface<E>{
    private class Node<E>{
        private E element;
        private Node<E> next;
        private Node<E> prev;
        private Node(E element){
            this.element = element;
        }
    }

    private class Iterator<E> implements IteratorInterface<E> {
        private Node<E> curr;
        private LinkedListRL<E> linkedListRL;

        private Iterator(LinkedListRL<E> linkedListRL){
            this.linkedListRL = linkedListRL;
            curr = (Node<E>) linkedListRL.head;
        }

        @Override
        public boolean hasNext() {
            return curr.next != null;
        }

        @Override
        public E next() {
            curr = curr.next;
            return curr.element;
        }

        @Override
        public void remove() {
            linkedListRL.remove((LinkedListRL<E>.Node<E>) curr);
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int count;

    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<>(element);
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            count++;
            return true;

    }

    @Override
    public void add(int index, E element) {
        Node<E> curr = find(index);
            Node<E> newNode = new Node<>(element);
            if(curr == head){
                head = newNode;
                newNode.next = curr;
            } else{
                curr.prev.next = newNode;
                newNode.next = curr;
            }
            count++;
        }

    @Override
    public void clear() {
        while(head != null) {
            remove(0);
        }
        count = 0;
    }

    @Override
    public boolean contains(E element) {
        return goTo(element) != null;
    }

    @Override
    public int indexOf(Object object) {
        Node<E> curr = head;
        int i =0;
            while(curr != null){
                if(curr.element.equals(object)){
                    return i;
                }
                i++;
                curr = curr.next;
            }

        return -1;
    }

    private Node<E> find(int index) {
        Node<E> curr = head;
        int i = 0;
        while (++i <= index && curr != null) {
            curr = curr.next;
        }
        return curr;
    }

    private Node<E> goTo(E element){
        Node<E> curr = head;
        while (curr != null){
            if(curr.element.equals(element)){
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    private boolean remove(Node<E> curr){
        if(curr.prev != null){
            curr.prev.next = curr.next;
        }else {
            head = curr.next;
        }
        if(curr.next != null){
            curr.next.prev = curr.prev;
        }else {
            tail = curr.prev;
        }
        count--;
        return true;
    }

    @Override
    public E get(int index) {
        return find(index).element;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean remove(int index) {
        remove(find(index));
        return true;
    }

    @Override
    public boolean remove(E element) {
        return remove(goTo(element));
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void set(int index, E element) {
        Node<E> curr = find(index);
        curr.element = element;
    }
    public String toString(){
        String s = "[";
        Node<E> curr = head;
        while (curr != null){
            s += curr.element;
            if(curr.next != null){
                s += ", ";
            }
            curr = curr.next;
        }
        s += "]";
        return s;
    }
}