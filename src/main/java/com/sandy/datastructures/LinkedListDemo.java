package com.sandy.datastructures;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

/**
 * Description
 */
public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedListDemo demo = new LinkedListDemo();
        Method[] methods = LinkedListDemo.class.getMethods();

        Arrays.stream(methods)
                .filter(m -> m.isAnnotationPresent(Run.class))
                .forEach(method -> {
                    try {
                        System.out.println(method.getName() + " is running -----");
                        method.invoke(demo);
                        System.out.println(method.getName() + " over -----");
                        System.out.println();
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });

//        System.out.println("遍历链表");
//        linkedList.print();

//        System.out.println("头部插入数据");
//        linkedList.insertFirst(10);

//        linkedList.print();

//        System.out.println("尾部插入数据");
//        linkedList.insertLast(111);
//        linkedList.print();




    }

    @Run
    public void testInsertFirst() {
        System.out.println("空链表头部插入数据");
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.insertFirst(new Random().nextInt());
        linkedList.print();
    }

    @Run
    public void testInsertLast() {
        System.out.println("空链表尾部插入数据");
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.insertLast(10);
        linkedList.print();
    }

    @Run
    public void testListTraversal() {
        System.out.println("遍历链表");
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.head = new Node<>(3);
        linkedList.head.next = new Node<>(2);
        linkedList.head.next.next = new Node<>(1);

        linkedList.print();
    }

    @Run
    public void testNotEmptyListInsertFirst() {
        System.out.println("非空链表头部插入数据");
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(21);
        Node<Integer> third = new Node<>(32);

        list.head = first;
        first.next = second;
        second.next = third;

        list.print();
        list.insertFirst(10);
        list.print();
    }

    @Run
    public void testNotEmptyListInsertLast() {
        System.out.println("非空链表尾部插入数据");
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(21);
        Node<Integer> third = new Node<>(32);

        list.head = first;
        first.next = second;
        second.next = third;

        list.print();
        list.insertLast(10);
        list.print();
    }
}

class SingleLinkedList<T> {
    Node<T> head;

    public void insertFirst(T newData) {
        Node<T> newNode = new Node<>(newData);

        Node<T> h = head;
        head = newNode;
        newNode.next = h;
    }

    public void insertLast(T newData) {
        Node<T> newNode = new Node<>(newData);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> nextNode = head;
        while (nextNode.next != null) {
            nextNode = nextNode.next;
        }
        nextNode.next = newNode;
    }

    public void print() {
        Node<T> nextNode = head;
        while (nextNode != null) {
            String msgTemplate = nextNode.next == null ? "[%s]" : "[%s] --> ";
            System.out.print(String.format(msgTemplate, nextNode.data));
            nextNode = nextNode.next;
        }
        System.out.println();
    }
}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Run {}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface BeforeRun {}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface AfterRun {}
