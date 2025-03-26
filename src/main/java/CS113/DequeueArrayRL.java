package CS113;

import java.util.NoSuchElementException;

public class DequeueArrayRL<E> implements DequeInterface<E>{
    static final private int DEFAULT_SIZE = 10;
    E[] array;
    int first = -1;
    int last = 1;
    int size = 0;

    public DequeueArrayRL(){
        resize(DEFAULT_SIZE);
        first = last = -1;
        size = 0;
    }
    private void resize(int size){
        if(array == null){
            E[] newArray = (E[]) new Object[size];
            array = newArray;
            return;
        }
        E[] newArray = (E[]) new Object[size];
        if(size < array.length){
            throw new IndexOutOfBoundsException();
        }
        for(int i = 0; i <= last; i++){
            newArray[i] = array[i];
        }
        int difference = (newArray.length) - array.length;
        if(first > last){
            for(int i= array.length-1; i > first + difference; i--){
                newArray[i] = array[i-difference];
            }
        }
        array = newArray;
    }

    @Override
    public boolean offerFirst(E element) {
        if(size == array.length){
            return  false;
        }
        addFirst(element);
        return true;
    }

    public boolean offerLast(E element){
        if(size == array.length){
            return false;
        }
        addLast(element);
        return true;
    }

    @Override
    public boolean addFirst(E element) {
        if (size == array.length - 1) {
            resize(array.length * 2);
        }


        if(size == 0){
            first = last = 0;
            array[first] = element;
            size++;
        }
        else {
            first--;
            if (first < 0) {
                first = array.length - 1;
            }
            array[first] = element;
            size++;
        }
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if(size == array.length){
            resize(size*2);
        }
        if (last == -1) {
            first = last = 0;
            array[last] = element;
            size++;
        } else {
            last++;
            if (last > array.length - 1) {
                last = 0;
            }
            array[last] = element;
            size++;
        }
        return true;
    }

    @Override
    public E removeFirst() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        E temp = array[first];
        array[first] = null;
        first++;
        size--;
        if(first > array.length){
            first = 0;
        }
        if(size == 0){
            first = last = -1;
        }
        return temp;
    }

    @Override
    public E removeLast() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        E temp = array[last];
        array[last] = null;
        last--;
        if(last < 0 ){
            last = array.length -1;
        }
        size--;
        if(size == 0){
            first = last = -1;
        }
        return temp;
    }

    @Override
    public E peekFirst() {
        if(size == 0){
            return null;
        }
        return array[first];
    }

    @Override
    public E peekLast() {
        if(size == 0){
            return null;
        }
        return array[last];
    }

    @Override
    public E pollFirst() {
        try {
            return removeFirst();
        } catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public E pollLast() {
        try{
            return removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        int size = size();
        for(int i = 0; i < array.length; i++){
            stringBuilder.append(array[i]);
            if(i< size){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
