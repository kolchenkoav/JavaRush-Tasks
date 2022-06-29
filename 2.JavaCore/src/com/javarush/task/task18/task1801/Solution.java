package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        // Максимальный байт
        // создаем объект FileInputStream, привязанный к файлу fileName
        FileInputStream inputStream = new FileInputStream(fileName);
        int maxValue = Integer.MIN_VALUE;

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read(); //прочитать очередной байт
            if (data > maxValue) {
                maxValue = data;
            }
        }
        inputStream.close(); // закрываем поток

        System.out.println(maxValue); //выводим Максимальный байт на экран.

    }
}
