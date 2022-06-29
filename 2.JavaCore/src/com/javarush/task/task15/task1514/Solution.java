package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.1, "1111111111111");
        labels.put(1.2, "2222222222222");
        labels.put(1.3, "3333333333333");
        labels.put(1.4, "4444444444444");
        labels.put(1.5, "5555555555555");
    }


    public static void main(String[] args) {
        System.out.println(labels);
    }
}
