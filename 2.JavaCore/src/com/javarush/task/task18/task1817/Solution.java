package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {return;}

        String fileName = args[0];

        int count = 0;
        int countOfSpaces = 0;
        try (FileReader fileReader = new FileReader(fileName)) {
            while (fileReader.ready()) {
                char readChar = (char) fileReader.read();
                count++;
                if (readChar == (int) ' ') { countOfSpaces++; }
            }
        }

        if (count != 0) {
            double result = (double) countOfSpaces / count * 100;
            System.out.printf("%.2f", result);
        }

    }
}
