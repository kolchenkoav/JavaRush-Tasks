package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultPrintStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        testString.printSomething();
        System.setOut(defaultPrintStream);

        String resultString = byteArrayOutputStream.toString();
        String[] resultArray = resultString.split(" ");
        int x = Integer.parseInt(resultArray[0]);
        int y = Integer.parseInt(resultArray[2]);
        String typeOperation = resultArray[1].trim();
        int resultInt = 0;

        if (typeOperation.equals("+")) {
            resultInt = x + y;
        } else if (typeOperation.equals("-")) {
                    resultInt = x - y;
        } else if (typeOperation.equals("*")) {
                    resultInt = x * y;
        } else {
            System.out.println("Bad type operation: "+typeOperation);
        }

        System.out.println(x + " " + typeOperation +" "+ y + " = " + resultInt);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

