package CS113;

import java.util.ArrayList;

public class SortingRL<E extends Comparable<E>> {

    public void swap(ArrayList<E> array, int i, int j){
        E temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }

    public void bubbleSort(ArrayList<E> array){
        for(int i=0; i<array.size(); i++){
            boolean swapped = false;
            for(int j=0; j<array.size() - 1; j++) {
                if (array.get(j).compareTo(array.get(j + 1)) > 0) {
                    E temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                    swapped = true;
                }
            }
            if(!swapped) return;
        }
    }

    public  void otherInsertion(ArrayList<E> array){
        for(int i = 1; i<array.size(); i++){
            E temp = array.remove(i);

            int j = i-1;
            while(j>= 0 && temp.compareTo(array.get(j)) < 0){
                j--;
            }
            array.add(temp);
        }
    }

    public void insertionSort(ArrayList<E> array){
        for(int i=0; i < array.size(); i++) {
            E temp = array.get(i);
            int j = i;
            while (j > 0 && temp.compareTo(array.get(j - 1)) < 0) {
                array.set(j, array.get(j - 1));
                j--;
            }
            array.set(j, temp);
        }
    }

    public ArrayList<E> merge(ArrayList<E> left, ArrayList<E> right){
        int l = 0;
        int r = 0;
        ArrayList<E> merged = new ArrayList<>();

        while(l < left.size() || r < right.size()){
            if(l == left.size()){
                merged.add(right.get(r++));
            } else if(r == right.size()){
                merged.add(left.get(l++));
            } else if(left.get(l).compareTo(right.get(r)) < 0){
                merged.add(left.get(l++));
            } else{
                merged.add(right.get(r++));
            }
        }
        return merged;
    }

    public ArrayList<E> mergeSort(ArrayList<E> array){
        if(array.size() <= 1){
            return array;
        }
        int start = 0;
        int middle = array.size()>>1;
        int end = array.size() - 1;

        ArrayList<E> left = new ArrayList<>();
        ArrayList<E> right = new ArrayList<>();

        for(int i = start; i < middle; i++){
            left.add(array.get(i));
        }
        for(int j = end; j >= middle; j--){
            right.add(array.get(j));
        }
        return merge(mergeSort(left), mergeSort(right));
    }

    public ArrayList<E> quickSort(ArrayList<E> array){
        if(array.size() <= 1){
            return array;
        }
        int start = 0;
        int pivot = array.size()-1;

        ArrayList<E> left = new ArrayList<>();
        ArrayList<E> right = new ArrayList<>();

        for(int i=0; i<array.size()-1; i++){
            if(array.get(i).compareTo(array.get(pivot)) > 0){
                right.add(array.get(i));
            } else{
                left.add(array.get(i));
            }
        }
        return quick(quickSort(left), array.get(pivot), quickSort(right));
    }
    public ArrayList<E> quick(ArrayList<E> left, E pivot, ArrayList<E> right){
        int l = 0;
        int r = 0;
        ArrayList<E> merged = new ArrayList<>();

        for(int i = 0; i <left.size(); i++){
            merged.add(left.get(i));
        }
        merged.add(pivot);
        for(int i = 0; i<right.size(); i++){
            merged.add(right.get(i));
        }
        return merged;
    }
}
