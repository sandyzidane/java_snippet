package com.sandy;

/**
 * @Description:
 * @Author: sangdi.he
 * @Time: 3/3/17 15:51
 */
public class GenStackTest {
    public static void main(String[] args) {
        GenStack<String> gs = new GenStack<>();
        System.out.println("Pushing 4 elements onto the stack");
        gs.push("One");
        gs.push("Two");
        gs.push("Three");
        gs.push("Four");

        System.out.println("Thre are " + gs.size() + " elements in stack");

        System.out.println("The top item is " + gs.peek());

        System.out.println();

    }
}
