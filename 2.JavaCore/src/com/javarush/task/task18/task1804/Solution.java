package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        int[] byteCountArray = new int[256];
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                int currByte = fileInputStream.read();
                byteCountArray[currByte]++;
            }
        }
//        int minCount = Integer.MAX_VALUE;
//        for (int byteCount : byteCountArray) {
//            if (byteCount > 0 && byteCount < minCount) minCount = byteCount;
//        }
//        ArrayList<Integer> resultList = new ArrayList<>();
//        for (int i = 0; i < byteCountArray.length; i++) {
//            if (byteCountArray[i] == minCount) resultList.add(i);
//        }
//        for (Integer resultItem : resultList) System.out.print(resultItem + " ");

        int minCount = Integer.MAX_VALUE;
        for (int byteCount : byteCountArray) {
            if (byteCount > 0 && byteCount < minCount) minCount = byteCount;
        }


        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();
        for (int i = 0; i < byteCountArray.length; i++) {
            if (byteCountArray[i] == minCount) {
                map.put((byte) i, byteCountArray[i]);
            }
        }


        int finalMinCount = minCount ;
        String s = map.entrySet()
                .stream()
                .sorted(Comparator.comparing(a->a.getKey()))
                .filter(a -> a.getValue() == (finalMinCount))
                .map(e -> e.getKey().toString())
                .collect(Collectors.joining(" "));

//                .reduce("", (partialString, element) -> partialString + " " + element);
        System.out.println(s + " ");
    }
}
