package com.sandy.learnIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Description:
 * @Author: sangdi.he
 * @Time: 3/16/17 15:58
 */
public class ScanXcan {
    public static void main(String[] args) throws IOException{
        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        }
        finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
