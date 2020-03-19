package com.sandy;

import java.util.LinkedList;

/**
 * @Description:
 * @Author: sangdi.he
 * @Time: 3/3/17 16:03
 */
public class GenQueue<E> {
    private LinkedList<E> list = new LinkedList<E>();

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue() {
        return list.poll();
    }

    public boolean hasItems() {
        return !list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void addItems(GenQueue<? extends E> q) {
        while (q.hasItems()) {
            list.addLast(q.dequeue());
        }
    }
}
