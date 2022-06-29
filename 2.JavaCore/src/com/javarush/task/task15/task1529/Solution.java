package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        //add your code here - добавьте код тут
//        если параметр равен "helicopter", статическому объекту CanFly result присвоить объект класса Helicopter;
//        если параметр равен "plane", считать второй параметр типа int (количество пассажиров),
//        статическому объекту CanFly result присвоить объект класса Plane.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String typeFly = reader.readLine();
        if (Objects.equals(typeFly, "helicopter")) {
            result = new Helicopter();
        } else if (Objects.equals(typeFly, "plane")) {
            int count = Integer.parseInt(reader.readLine());
            result = new Plane(count);
        }

        reader.close();
    }
}
