package CS113;

import Interfaces.ListInterface;

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
    //    AVLBinarySearchTreeRL<Integer> numbers = (AVLBinarySearchTreeRL<Integer>) myBST;
        HeapRL<Integer> num = new HeapRL<>();

        ArrayList<Integer> hat = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i<20; i++){
            hat.add(random.nextInt(100));
        }
        SortingRL<Integer> sortingHat = new SortingRL<>();

        GraphRL<String> stuff = new GraphRL<>();
        stuff.add("A");
        stuff.add("B");
        stuff.add("C");
        stuff.add("D");
        stuff.add("E");
        stuff.edge("A", "B", false);
        stuff.edge("B", "C", false);
        stuff.printGraph();



//        System.out.println(hat);
//        hat = sortingHat.quickSort(hat);
//        System.out.println(hat);

        for(int i =0; i<10; i++){
            testArray.add(i);
            ourList.add(i);
            stack.push(i);
            //numbers.insert(i);
            myStack.push(i);
            myQueue.push(i);
            num.add(i);
        }

//        System.out.println(num);
//        //num.add(-1);
//        num.poll();
//        System.out.println(num);



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