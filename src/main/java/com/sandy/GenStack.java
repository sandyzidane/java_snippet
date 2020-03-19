package com.sandy;

import java.util.LinkedList;

/**
 * @Description:
 * @Author: sangdi.he
 * @Time: 3/3/17 15:48
 */
public class GenStack<E> {
    private LinkedList<E> list = new LinkedList<E>();

    public void push(E e) {
        list.addFirst(e);
    }

    public E pop() {
        return list.poll();
    }

    public E peek() {
        return list.peek();
    }

    public boolean hasItem(E item) {
        return !list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
