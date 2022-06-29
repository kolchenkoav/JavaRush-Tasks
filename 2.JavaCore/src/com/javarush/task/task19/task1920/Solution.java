package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {
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

        TreeSet<String> names = getNamesSalary(salary);
        names.forEach(System.out::println);
    }

    private static TreeSet<String> getNamesSalary(TreeMap<String, Double> salary) {
        double maxSalary = getMaxSalary(salary);
        TreeSet<String> names = new TreeSet<>();
        for (String name : salary.keySet()) {
            if (maxSalary == salary.get(name)) {
                names.add(name);
            }
        }
        return names;
    }

    private static double getMaxSalary(TreeMap<String, Double> salary) {
        double maxSalary = salary.firstEntry().getValue();
        for (double value : salary.values()) {
            if (value > maxSalary) {
                maxSalary = value;
            }
        }
        return maxSalary;
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
