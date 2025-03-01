package CS113;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayListRL<Integer> testArray = new ArrayListRL<>();
        ListInterface<Integer> ourList = new LinkedListRL<>();
        List<Integer> javaList = new LinkedList<>();

        for(int i =0; i<10; i++){
            testArray.add(i);
            ourList.add(i);
            javaList.add(i);
        }

        testArray.add(5,null);
        //ourList.add(5,null);
        javaList.add(5,null);

        System.out.println(testArray);
        System.out.println(testArray.size());

        System.out.println(ourList);
        System.out.println(ourList.size());

        ourList.clear();
        System.out.println(ourList);
        System.out.println(ourList.size());


    }
}