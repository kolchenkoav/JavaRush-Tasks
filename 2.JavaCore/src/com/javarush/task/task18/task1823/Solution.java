package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;


/* 
Нити и байты d:\log4.txt  97 char = a
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readString;
        while (!(readString = reader.readLine()).equals("exit")) {
            new ReadThread(readString).start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            int maxCountByte = 0;
            try {
                maxCountByte = Files.lines(Paths.get(fileName))
                        .collect(Collectors.joining())
                        .chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toMap(
                                Function.identity(),
                                (s) -> 1,
                                (existing, current) -> ++existing))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue()).orElseThrow().getKey();

            } catch (IOException e) {
                e.printStackTrace();
            }

            /*
            int[] bytesCount = new int[256];

            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                while (fileInputStream.available() > 0) {
                    int aByte = fileInputStream.read();
                    bytesCount[aByte]++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            int maxCount = 0;
            int maxCountByte = 0;
            for (int i = 0; i < bytesCount.length; i++) {
                if (bytesCount[i] > maxCount) {
                    maxCount = bytesCount[i];
                    maxCountByte = i;
                }
            }
*/
            resultMap.put(fileName, maxCountByte);
            resultMap.forEach((s, integer) -> System.out.println(s + " " + integer + " char = " + (char) integer.byteValue()));

        }
    }
}
