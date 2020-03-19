package com.sandy;

/**
 * @Description:
 * @Author: sangdi.he
 * @Time: 3/3/17 16:09
 */
public class GenQueueTest {
    public static void main(String[] args) {
        GenQueue<Employee> empList = new GenQueue<>();

        GenQueue<HourlyEmployee> hList = new GenQueue<>();
        hList.enqueue(new HourlyEmployee("Trump", "Donald"));
        hList.enqueue(new HourlyEmployee("Gates", "Bill"));
        hList.enqueue(new HourlyEmployee("Forbes", "Steve"));

        empList.addItems(hList);

        while (empList.hasItems()) {
            Employee emp = empList.dequeue();
            System.out.println(emp.firstName + " " + emp.lastName);
        }

    }

    static class Employee {
        public String lastName, firstName;
        public Employee() {}
        public Employee(String last, String first) {
            this.lastName = last;
            this.firstName = first;
        }

        public String toString() {
            return firstName + " " + lastName;
        }
    }

    static class HourlyEmployee extends Employee {
        public double hourlyRate;

        public HourlyEmployee(String last, String first) {
            super(last, first);
        }
    }
}
