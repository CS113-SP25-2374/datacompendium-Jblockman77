package CS113;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayListRL<Integer> testArray = new ArrayListRL<>();
        ListInterface<Integer> ourList = new LinkedListRL<>();
        Stack<Integer> stack = new Stack<>();
        StackRL<Integer> myStack = new StackRL<>();
        QueueRL<Integer> myQueue = new QueueRL<>();
        DequeueArrayRL<Integer> numbers = new DequeueArrayRL<>();

        System.out.println(numbers);
        System.out.println(numbers.pollFirst());

        for(int i =0; i<10; i++){
            testArray.add(i);
            ourList.add(i);
            stack.push(i);
            numbers.addFirst(i);
            myStack.push(i);
            myQueue.push(i);
        }

        System.out.println(numbers);
        numbers.pollLast();
        System.out.println(numbers);
        System.out.println(numbers.peekLast());
        System.out.println(numbers);
        System.out.println(numbers.size());
        System.out.println(numbers);
        System.out.println(numbers.pollFirst());
        System.out.println(numbers);



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