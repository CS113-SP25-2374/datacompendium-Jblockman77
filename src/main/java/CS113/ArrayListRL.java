package CS113;

public class ArrayListRL<E> implements ListInterface<E>{
    final static int INITIAL_CAPACITY = 10;
    private E[] array;
    private int size;
    private int capacity = 0;
    public ArrayListRL(){
        array = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
        capacity = 10;
    }

    @Override
    public E get(int index){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        else{
            return array[index];
        }
    }

    @Override
    public boolean isEmpty() {
        for(int i = 0; i< array.length; i++){
            if(array[i] != null){
                return false;
            }
        }
        return true;
    }

    @Override
    public void add(int index, E element){
        if(index < 0 || index > size){
            System.out.println("Out of range");
        }
        else{
            if(size == capacity){
                reallocate();
            }
            this.size++;
            for(int i = size-1; i >= index; i--){
                this.array[i+1] = this.array[i];
            }
            this.array[index] = element;
        }
    }

    @Override
    public void clear() {
        for(int i = 0; i < array.length-1; i++){
            array[i] = null;
        }
    }

    @Override
    public boolean contains(E element) {
        return (indexOf(element) != -1);
    }

    @Override
    public int indexOf(Object object) {
        if(object == null){
            return -1;
        }
        else{
            for(int i=0; i<array.length; i++){
                if(object.equals(array[i])){
                    return i;
                }
            }
            return -1;
        }
    }

    public boolean remove(int index){
        if(index < 0 || index >= size){
            System.out.println("Out of range");
            return false;
        }
        else{
            E element = array[index];
            for(int i = index; i<size-1; i++){
                array[i] = array[i+1];
            }
            array[size-1] = null;
            size--;
            return true;
        }
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if(index == -1){
            return false;
        }
        else{
            remove(index);
            return true;
        }
    }

    @Override
    public int size() {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != null) {
                return i + 1;
            }
        }
        return 0;
    }

    @Override
    public void set(int index, E element) {
        array[index] = element;
    }

    public boolean add(E generic){
        if(size == capacity){
            reallocate();
        }
        array[size] = generic;
        size++;
        return true;
    }
    private void reallocate(){
        this.capacity = (this.capacity*2);
        E[] newData = (E[]) new Object[this.capacity];
        for(int i = 0; i < size; i++){
            newData[i] = array[i];
        }
        this.array = newData;
    }
    @Override
    public String toString(){
        String s = "[";
        for(int i = 0; i < size; i++){
            s += array[i];
            if(i != (size-1)){
                s = s + ", ";
            }
        }
        s += "]";
        return s;
    }
}
