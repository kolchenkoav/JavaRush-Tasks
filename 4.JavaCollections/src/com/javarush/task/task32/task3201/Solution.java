package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        if (args.length == 0) {
            System.out.println(" 1) fileName - путь к файлу;\n" +
                                "2) number - число, позиция в файле;\n" +
                                "3) text - текст.");
            return;
        }

        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        long length = raf.length();
        number = number > length ? length : number;

        raf.seek(number);
        raf.write(text.getBytes());
        //raf.writeBytes(text);

        raf.close();

//        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
//            long number = Long.parseLong(args[1]);
//            long length = raf.length();
//            number = number > length ? length : number;
//            raf.seek(number);
//            raf.write(args[2].getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
