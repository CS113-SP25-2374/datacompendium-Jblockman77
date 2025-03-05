package CS113;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayListRL<Integer> testArray = new ArrayListRL<>();
        ListInterface<Integer> ourList = new LinkedListRL<>();
        Stack<Integer> stack = new Stack<>();
        StackRL<Integer> myStack = new StackRL<>();
        QueueRL<Integer> myQueue = new QueueRL<>();
        Deque<Integer> numbers = new ArrayDeque<>();

        for(int i =0; i<10; i++){
            testArray.add(i);
            ourList.add(i);
            stack.push(i);
            numbers.add(i);
            myStack.push(i);
            myQueue.push(i);
        }

        System.out.println(myQueue);
        myQueue.pop();
        System.out.println(myQueue);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());
        System.out.println(myQueue.pop());
        System.out.println(myQueue);



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