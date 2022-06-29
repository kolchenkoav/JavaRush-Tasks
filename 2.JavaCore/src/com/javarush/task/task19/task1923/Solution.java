package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {return;}
        String fileInput = args[0];
        String fileOutput = args[1];

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileInput));
             FileWriter fileWriter = new FileWriter(fileOutput)) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                checkedTask(line, fileWriter);
            }
        }
    }

    private static void checkedTask(String line, FileWriter fileWriter) throws IOException {
        String lineOut = "";
        String[] splitedLine = line.split(" ");
        for (String word : splitedLine) {
            if (word.matches(".*[0-9].*")) {
                lineOut = lineOut + word + " ";
            }
        }
        fileWriter.write(lineOut);
    }
}



/*
Слова с цифрами
*/

//public class Solution {
//    public static void main(String[] args) {
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
//             FileWriter fileWriter = new FileWriter(args[1])) {
//            String fileReadLine;
//            String[] splitedLine;
//            while ((fileReadLine = fileReader.readLine()) != null) {
//                splitedLine = fileReadLine.split(" ");
//                for (String word : splitedLine) {
//                    if (word.matches(".*[0-9].*")) {
//                        fileWriter.write(word + " ");
//                    }
//                }
//            }
//        } catch (IOException ignored) {
//        }
//    }
//}