package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        -e fileName fileOutputName
//        -d fileName fileOutputName
        int shift = 32;

        String mode = args[0];
        if (!(mode.equals("-e") || mode.equals("-d"))) return;

        String fileName = args[1];
        String fileOutputName = args[2];

        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName)) {

            if (mode.equals("-e")) {                // шифрование
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read() + shift);
                }
            } else if (mode.equals("-d")) {         // дешифрование
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read() - shift);
                }
            }
        }


    }

}
