package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        String fileInput;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileInput = bufferedReader.readLine();
        }

        try (BufferedReader bReader = new BufferedReader(new FileReader(fileInput))) {
            while (bReader.ready()) {
                String line = bReader.readLine();
                if (checkTask(line)) {
                    System.out.println(line);
                }
            }
        }
    }

    private static boolean checkTask(String line) {
        int count = 0;
        if (line.contains(words.get(0))) {count++;}
        if (line.contains(words.get(1))) {count++;}
        if (line.contains(words.get(2))) {count++;}
        if (count == 2) {return true;}
        else {return false;}
    }
}

//public class Solution {
//    public static List<String> words = new ArrayList<String>();
//
//    static {
//        words.add("файл");
//        words.add("вид");
//        words.add("В");
//    }
//
//    public static void main(String[] args) {
//        String file1 = null;
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            file1 = reader.readLine();
//
//        } catch (IOException ignore) {
//            /* NOP */
//        }
//
//        try (BufferedReader in = new BufferedReader(new FileReader(file1))) {
//            while (in.ready()) {
//                String readedString = in.readLine();
//                String[] splitedReadedString = readedString.split(" ");
//
//                int wordCount = 0;
//                for (String s : splitedReadedString) {
//                    if (words.contains(s)) {
//                        wordCount++;
//                    }
//                }
//
//                if (wordCount == 2)
//                    System.out.println(readedString);
//            }
//        } catch (IOException ignore) {
//            /* NOP */
//        }
//    }
//}