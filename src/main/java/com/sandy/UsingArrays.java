package com.sandy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: sangdi.he
 * @Time: 3/3/17 10:54
 */
public class UsingArrays {



    public static void main(String[] args) {
        LinkedList<String> officers = new LinkedList<>();
        officers.add("Blake");
        officers.add("Burns");
        officers.add("Houlihan");
        officers.add("Pierce");
        officers.add("McIntyre");
        officers.add(2, "tuttle");
        officers.add(2, "tuttle");
        officers.add(2, "tuttle");

        officers.stream();

        officers.stream()
//            .filter(s -> s.startsWith("B"))
//            .distinct()
//            .limit(4)
            .forEach(s -> System.out.println(s));
//        for (String s: officers) {
//            System.out.println(s);
//        }
    }
}
