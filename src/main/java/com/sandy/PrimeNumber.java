package com.sandy;

/**
 * @Description:
 * @Author: sangdi.he
 * @Time: 3/14/17 09:50
 */
public class PrimeNumber {

    public static void main(String[] args) {
        int[] arr = new int[10001];


        for (int i=0; i<arr.length; i++) {
            arr[i] = i;
        }

        //非质数下标,对应数组元素值为0; 质数下标,对应数组元素值为1
        for (int j=2; j<arr.length; j++) {

            // j 取值从2到10000;
            // n 为倍数,从2到使 j*n <= 10000;
            for (int n =2; j * n <= 10000; n++) {
                arr[j*n] = 0;
            }
        }

        for (int k: arr) {
            if (k != 0) {
                System.out.println(k);
            }
        }

    }
}
