package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static <map> void main(String[] args) throws IOException {
        if (args.length == 0) {return;}

        String fileName = args[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        try (FileReader br = new FileReader(fileName)) {
            while (br.ready()) {
                int aByte = br.read();
                map.merge(aByte, 1, (a, b) -> a + b);
            }
        }
        map.forEach((key, value) -> System.out.println((char) key.intValue() +" " + value));
    }
}
