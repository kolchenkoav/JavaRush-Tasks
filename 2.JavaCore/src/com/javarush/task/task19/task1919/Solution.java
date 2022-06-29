package com.javarush.task.task19.task1919;

import java.io.*;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) return;

        TreeMap<String, Double> salary = new TreeMap<>();
        String fileName = args[0];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                addParseLineInSalary(line, salary);
            }
        } catch (IOException ignore) {
            /*NOP */
        }
        salary.forEach((n, v)->System.out.println(n+" "+v));
    }

    private static void addParseLineInSalary(String line, TreeMap<String, Double> salary) {
        String[] splitLine = line.trim().split(" ");
        String name = splitLine[0];
        Double value = Double.valueOf(splitLine[1]);
        Double currentValue;
        if (salary.containsKey(name)) {
            currentValue = salary.get(name);
            salary.put(name, value + currentValue);
        } else {
            salary.put(name, value);
        }
    }
}
