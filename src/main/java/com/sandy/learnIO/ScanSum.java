package com.sandy.learnIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * @Description:
 * @Author: sangdi.he
 * @Time: 3/16/17 17:29
 */
public class ScanSum {
    public static void main(String[] args) throws IOException{
        Scanner s = null;
        double sum = 0;
        try {
            s = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
            s.useLocale(Locale.US);

            while (s.hasNext()) {
                sum += s.nextDouble();
            }
        }
        finally {
            if (s != null) {
                s.close();
            }
        }
        System.out.println(sum);
    }
}
