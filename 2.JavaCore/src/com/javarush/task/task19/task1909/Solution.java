package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileInput;
        String fileOutput;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите имя файла для чтения: ");
            fileInput = bufferedReader.readLine();
            System.out.print("Введите имя файла для записи: ");
            fileOutput = bufferedReader.readLine();
        }

        ArrayList<String> fileContent = new ArrayList<>();
        try (BufferedReader readerInput = new BufferedReader(new FileReader(fileInput))) {
            while (readerInput.ready()) {
                fileContent.add(readerInput.readLine());
            }
        }

        try (BufferedWriter writerOutput = new BufferedWriter(new FileWriter(fileOutput))) {
            for (String s: fileContent) {
                writerOutput.write(s.replaceAll("\\.","!"));
            }
        }
    }
}
