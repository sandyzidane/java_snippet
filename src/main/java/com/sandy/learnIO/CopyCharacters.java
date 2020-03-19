package com.sandy.learnIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description:
 * @Author: sangdi.he
 * @Time: 3/16/17 15:35
 */
public class CopyCharacters {
    public static void main(String[] args)  throws IOException{
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader("xanadu.txt");
            fileWriter = new FileWriter("characteroutput.txt");
            int c;

            while ((c = fileReader.read()) != -1) {
                fileWriter.write(c);
            }
        }
        finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
