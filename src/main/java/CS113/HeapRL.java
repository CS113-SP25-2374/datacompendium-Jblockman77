package CS113;

public class HeapRL<E extends Comparable<E>>{
    ArrayListRL<E> theArray = new ArrayListRL<>();
    public boolean add(E element){
        theArray.add(element);
        swap(element, theArray.size()-1);
        return true;
    }

    public void swap(E element, int index){
        if(index <= 0){
            return;
        }else{
            if(theArray.get(index).compareTo(theArray.get((index - 1) / 2)) < 0){
                E temp = theArray.get((index - 1)/2);
                theArray.set(((index - 1)/2), theArray.get(index));
                theArray.set(index, temp);
                swap(theArray.get((index-1)/2), (index-1)/2);
            }

        }
    }

    public void swapDown(E element, int index){
        int childLeft = index * 2 + 1;
        int childRight = index * 2 + 2;
        int smallest = index;

        if(childLeft < theArray.size()){
            smallest = childLeft;
        } else if(childRight < theArray.size()){
            smallest = childRight;
        }
        if(smallest == index){
            return;
        }

        E smallestValue = theArray.get(smallest);
        if(element.compareTo(smallestValue) > 0);
        theArray.set(index, smallestValue);
        theArray.set(smallest, element);
        swapDown(element, smallest);
    }

    public void poll(){
        E first = theArray.get(0);
        E last = theArray.get(theArray.size() -1);
        theArray.set(0, last);
        theArray.remove(theArray.size()-1);
        swapDown(last, 0);
    }

    public E peek(){
        return theArray.get(0);
    }

    public String toString(){
        return theArray.toString();
    }
}
