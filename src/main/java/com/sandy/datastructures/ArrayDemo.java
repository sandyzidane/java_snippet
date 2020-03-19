package com.sandy.datastructures;

import java.util.Arrays;

/**
 * Description
 */
public class ArrayDemo {



    public static void main(String[] args) {
        int[] intArr = new int[]{99, 88, 77, 66, 55};

        System.out.println(intArr[0]);
        System.out.println(intArr[intArr.length - 1]);

        for (int i = 0; i < intArr.length; i++) {
            System.out.println(String.format("index: %s, value: %s", i, intArr[i]));
        }

        int[] copyIntArr = intArr.clone();
        System.out.println(copyIntArr.length);

        Arrays.sort(intArr);
        for (int i : intArr) {
            System.out.println(i);
        }
    }
}
