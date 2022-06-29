package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileInputStream = bufferedReader.readLine();         //  имя файла для чтения  c:\data.txt
        String fileOutputStream1 = bufferedReader.readLine();       //  файл для записи 1
        String fileOutputStream2 = bufferedReader.readLine();       //  -//- 2

        FileInputStream inputStream = new FileInputStream(fileInputStream);

        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream1 = new FileOutputStream(fileOutputStream1);
        FileOutputStream outputStream2 = new FileOutputStream(fileOutputStream2);

        if (inputStream.available() > 0) {
            int countByte = inputStream.available()+1;                // Кол-во байт в файле при считывании

            byte[] buffer1 = new byte[countByte/2];                 // кол-во байт для записи в первый файл
            byte[] buffer2 = new byte[countByte-buffer1.length];    // -//- 2 й

            int count = inputStream.read(buffer1);
            outputStream1.write(buffer1, 0, count);

            count = inputStream.read(buffer2);
            outputStream2.write(buffer2, 0, count);
        }

        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
