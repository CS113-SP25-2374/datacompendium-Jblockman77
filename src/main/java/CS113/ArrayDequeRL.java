package CS113;

import Interfaces.DequeInterface;

public class ArrayDequeRL<E> implements DequeInterface<E> {
    E[] array;
    int first;
    int last;
    int count;

    public ArrayDequeRL() {
        resize(10);
        first = -1;
        last = -1;
        count = 0;
    }

    private void resize(int newSize) {
        if (array == null) {
            array = (E[]) new Object[newSize];
            return;
        }

        E[] newArray = (E[]) new Object[newSize];
        for (int i = 0; i <= last; i++) {
            newArray[i] = array[i];
        }
        int diff = newArray.length - array.length;
        for (int i = newArray.length - 1; i >= first + diff; i--) {
            newArray[i] = array[i - diff];
        }
        array = newArray;
    }

    @Override
    public boolean offerFirst(E element) {
        if (count == array.length - 1) {
            return false;
        }
        addFirst(element);
        return true;
    }

    @Override
    public boolean offerLast(E element) {
        if (count == array.length - 1) {
            return false;
        }
        addLast(element);
        return true;
    }

    @Override
    public boolean addFirst(E element) {
        if (count == array.length - 1) {
            resize(array.length * 2);
        }

        if (first == -1) {
            first = 0;
            last = first;
            array[first] = element;
            count++;
        } else {
            first--;
            if (first < 0) {
                first = array.length - 1;
            }
            array[first] = element;
            count++;
        }
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (count == array.length - 1) {
            resize(array.length * 2);
        }

        if (last == -1) {
            first = last = 0;
            array[last] = element;
            count++;
        } else {
            last++;
            if (last > array.length - 1) {
                last = 0;
            }
            array[last] = element;
            count++;
        }
        return true;
    }

    @Override
    public E removeFirst() {
        E temp = array[first];
        array[first] = null;
        first++;
        return temp;
    }

    @Override
    public E removeLast() {
        E temp = array[last];
        array[last] = null;
        last--;
        return temp;
    }

    @Override
    public E peekFirst() {
        return array[first];
    }

    @Override
    public E peekLast() {
        return array[last];
    }

    @Override
    public E pollFirst() {
        return removeFirst();
    }

    @Override
    public E pollLast() {
        return removeLast();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");

        int size = size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(array[i]);
            if (i < size - 1) stringBuilder.append(", ");
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}