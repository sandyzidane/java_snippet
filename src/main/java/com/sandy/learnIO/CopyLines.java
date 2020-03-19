package com.sandy.learnIO;

import java.io.*;

/**
 * @Description:
 * @Author: sangdi.he
 * @Time: 3/16/17 15:40
 */
public class CopyLines {

    public static void main(String[] args) throws IOException{
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));
            String l;

            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

}
