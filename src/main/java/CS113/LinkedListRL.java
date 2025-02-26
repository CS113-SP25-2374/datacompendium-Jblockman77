package CS113;

public class LinkedListRL<E> implements ListInterface<E>, IterableInterface<E>{

    private class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;
        private Node(E element){
            this.element = element;
        }
    }

    private class Iterator<E> implements IteratorInterface{
        LinkedListRL<E>.Node<E> curr;
        LinkedListRL<E> list;

        private Iterator(LinkedListRL<E> parentList){
            list = parentList;
            curr = list.head;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Object next() {
            LinkedListRL<E>.Node<E> temp = curr;
            curr = curr.next;
            return temp.element;
        }

        @Override
        public void remove() {
            if(list.head == null) throw new IllegalStateException();

            if(curr != null){
                list.unLink(curr);
            }

            list.unLink(curr);

        }
    }

    Node<E> head;
    Node<E> tail;
    int size;
    private Node<E> getAt(int index){
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();

        Node<E> curr = head;
        for(int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public boolean add(E element) {
        Node<E> node = new Node<>(element);
        size++;
        if(head == null){
            head = tail = node;
            return true;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;

        return true;
    }

    private void unLink(Node<E> node){
        Node<E> curr = node;
        Node<E> prev = curr.prev;
        Node<E> next = curr.next;
        size--;
        if(curr == head){
            head = curr.next;
        }
        if(curr == tail){
            tail = curr.prev;
        }
        if(prev != null){
            prev.next = next;
        }
        if(head != null){
            head.prev = prev;
        }
    }

    @Override
    public void add(int index, E element) {
        Node<E> node = new Node<>(element);
        Node<E> curr = getAt(index);
        size++;

        node.next = curr.next;
        curr.next = node;
        node.prev = curr;
        if(node.next != null){
            node.next.prev = node;
        }
    }

    @Override
    public void clear() {
        while (size != 0){
            remove(size);
            size--;
        }
    }

    @Override
    public boolean contains(E element) {
        if(head == null) return false;
        int count = 0;
        while(count != size){
            if()
        }
    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (head==null);
    }

    @Override
    public boolean remove(int index) {
        unLink(getAt(index));
        return true;
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public IterableInterface<E> interator(){

        return this;
    }
}