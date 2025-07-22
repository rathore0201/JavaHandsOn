package org.example.stringOps;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StringOperations {
    public static void stringArrays(){
        String[] strs = {
            "Hello",
            "World",
            "Java",
            "Programming"
        };

        String str = "Hello";

        int[] intArray = {1, 2, 3, 4, 5};

        Arrays.stream(intArray).forEach(System.out::println);

        Map<Character, Long> m = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        m.forEach((k, v) -> System.out.println(k + " : " + v));

    }

    private static Integer it;
    public static void program1() {
        if(it > 20){
            System.out.println("it is greater than 20");
        } else {
            System.out.println("it is less than or equal to 20");
        }
    }
}
