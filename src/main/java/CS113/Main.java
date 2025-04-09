package CS113;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayListRL<Integer> testArray = new ArrayListRL<>();
        ListInterface<Integer> ourList = new LinkedListRL<>();
        Stack<Integer> stack = new Stack<>();
        StackRL<Integer> myStack = new StackRL<>();
        QueueRL<Integer> myQueue = new QueueRL<>();
        ArrayDequeRL<Integer> myDeque = new ArrayDequeRL<>();
        BinarySearchTreeRL<Integer> myBST = new BinarySearchTreeRL<Integer>();
        //AVLBinarySearchTreeRL<Integer> numbers = (AVLBinarySearchTreeRL<Integer>) myBST;
        HeapRL<Integer> num = new HeapRL<>();

        for(int i =0; i<10; i++){
            //testArray.add(i);
            //ourList.add(i);
            //stack.push(i);
            //numbers.insert(i);
            //myStack.push(i);
            //myQueue.push(i);
            num.add(i);
        }

        System.out.println(num);
        //num.add(-1);
        num.poll();
        System.out.println(num);



        //testArray.add(5,null);
        //ourList.add(5,null);
       // javaList.add(5,null);

        //System.out.println(testArray);
        //System.out.println(testArray.size());

        //System.out.println(ourList);
        //System.out.println(ourList.size());

        //ourList.clear();
        //System.out.println(ourList);
       //System.out.println(ourList.size());

    }
}