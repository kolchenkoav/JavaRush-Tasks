package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String key = null;
        while (!(key = reader.readLine()).equals("exit")) {

//            Для каждого значения, кроме "exit", вызвать метод print(). Если значение:
//            содержит точку '.', вызвать метод print() для Double;
//            больше нуля, но меньше 128, вызвать метод print() для short;
//            меньше либо равно нулю или больше либо равно 128, вызвать метод print() для Integer;
//            иначе — вызвать метод print() для String.
            try {
                if (key.contains(".")) {
                    print(Double.parseDouble(key));
                } else {
                    int i = Integer.parseInt(key);
                    if (i > 0 && i < 128) {
                        print((short) i);
                    } else {
                        print(i);
                    }
                }
            }
            catch (Exception e) {
                print(key);
            }
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
