package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите имя первого файла: ");
        String fileName1 = reader.readLine();
        System.out.print("Введите имя второго файла: ");
        String fileName2 = reader.readLine();
        System.out.print("Введите имя третьего файла: ");
        String fileName3 = reader.readLine();

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
             FileInputStream fileInputStream2 = new FileInputStream(fileName2);
             FileInputStream fileInputStream3 = new FileInputStream(fileName3)) {

            int countBytes = fileInputStream2.available();
            if (countBytes >  fileInputStream3.available()) {
                countBytes =  fileInputStream3.available();
            }
            byte[] buffer = new byte[countBytes];

            while (fileInputStream2.available() > 0)
            {
                // прочитать очередной блок байт в переменную buffer и реальное количество в count
                int count = fileInputStream2.read(buffer);
                fileOutputStream.write(buffer, 0, count); //записать блок(часть блока) во второй поток
            }
            while (fileInputStream3.available() > 0)
            {
                int count = fileInputStream3.read(buffer);
                fileOutputStream.write(buffer, 0, count);
            }
        }
    }
}
