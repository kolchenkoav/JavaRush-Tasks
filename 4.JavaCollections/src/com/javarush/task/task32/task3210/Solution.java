package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        if (args.length == 0) {
            System.out.println(" 1) fileName - путь к файлу;\n" +
                    "2) number - число, позиция в файле;\n" +
                    "3) text - текст.");
            return;
        }
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            long fileLength = raf.length();

            raf.seek(number);
            byte[] readBytes = new byte[text.length()];
            raf.read(readBytes, 0, text.length());

            String readString = new String(readBytes);

            raf.seek(fileLength);
            if (readString.equals(text)) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
