package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/* 
Самые частые байты
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
        //for (Integer resultItem : byteCountArray) System.out.print(resultItem + " ");

        // сортировка массива
//        int maxCount = 0;
//        for (int byteCount : byteCountArray) {
//            if (byteCount > maxCount) maxCount = byteCount;
//        }
//        ArrayList<Integer> resultList = new ArrayList<>();
//        for (int i = 0; i < byteCountArray.length; i++) {
//            if (byteCountArray[i] == maxCount) resultList.add(i);
//        }
//        for (Integer resultItem : resultList) System.out.print(resultItem + " ");

        int maxCount1 = 0;
        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();

        for (int i = 0; i < byteCountArray.length; i++) {
            if (byteCountArray[i] >= maxCount1) {
                if (maxCount1 > 0) {
                    map.put((byte) i, byteCountArray[i]);
                }
                maxCount1 = byteCountArray[i];
            }
        }


        int finalMaxCount = maxCount1 ;
        String s = map.entrySet()
                .stream()
                .filter(a -> a.getValue() == (finalMaxCount))
                .map(e -> e.getKey().toString())
                .collect(Collectors.joining(" "));
//                .reduce("", (partialString, element) -> partialString + " " + element);
        System.out.println(s + " ");


    }

}
